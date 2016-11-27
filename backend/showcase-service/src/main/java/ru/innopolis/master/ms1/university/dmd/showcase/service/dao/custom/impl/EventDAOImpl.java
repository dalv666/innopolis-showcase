package ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Movie;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.*;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.EventDAOCustom;
import ru.innopolis.master.ms1.university.dmd.showcase.service.mapper.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by dalv on 02.11.2016.
 */
public class EventDAOImpl extends JdbcDaoSupport implements EventDAOCustom {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    EventDAOImpl(DataSource dataSource){
        setDataSource(dataSource);
    }

    @Override
    public List<Movie> findMovieByAwardCountAndDate(double rate, LocalDate date) {
        Query nativeQuery = entityManager.createNativeQuery("SELECT m.mve_name\n" +
                "FROM movie m" +
                "WHERE (SELECT count(*)" +
                "  FROM movie_starred ms" +
                "  WHERE ms.movie_mve_id = m.mve_id)" +
                "  =" +
                "  (SELECT count(*)" +
                "  FROM person p LEFT JOIN " +
                "    (SELECT pr.person_prs_id AS prs_id, AVG(pr.rating) AS avg_rate FROM person_rate pr GROUP BY prs_id) rates ON p.prs_id = rates.prs_id LEFT JOIN " +
                "    (SELECT pa.person_prs_id AS prs_id, COUNT(*) AS award_count FROM person_award pa GROUP BY prs_id) awards ON p.prs_id = awards.prs_id " +
                "      WHERE (rates.avg_rate >= ? OR awards.award_count >= ?) AND p.prs_id IN " +
                "        (SELECT ms.person_prs_id FROM movie_starred ms WHERE ms.movie_mve_id = m.mve_id)) " +
                "  AND m.mve_created >= ?");
        nativeQuery.setParameter(1, rate);
        nativeQuery.setParameter(2, date);
        nativeQuery.executeUpdate();
        return nativeQuery.getResultList();
    }

    public List<EventDTO> findEventsByFilters(String title, String cityName, Long price) {
        String sql = "SELECT e.evt_id, e.evt_title, e.evt_type, e.evt_price, e.evt_duration, p.pic_link, l.lct_name, c.cty_name, e.evt_description, e.evt_capacity " +
                "FROM event e LEFT JOIN location l ON e.location_lct_id = l.lct_id " +
                "LEFT JOIN picture p ON e.picture_pic_id = p.pic_id " +
                "LEFT JOIN city c ON l.city_cty_id = c.cty_id " +
                "WHERE e.evt_title LIKE ? AND " +
                "c.cty_name LIKE ? AND " +
                "e.evt_price <= ?";
        List<EventDTO> query = getJdbcTemplate().query(sql, new Object[]{"%"+title+"%", "%"+cityName+"%", price}, new EventMapper());
        return query;
    }



    public List<EventDTO> searchEvent(String text) {
        String sql = "SELECT e.evt_id,e.evt_title,e.evt_type,e.evt_price, e.evt_duration, pic.pic_link,l.lct_name,  c.cty_name, e.evt_description,e.evt_capacity " +
                "FROM event e LEFT JOIN location l ON e.location_lct_id = l.lct_id LEFT JOIN city c ON l.city_cty_id = c.cty_id " +
                " LEFT JOIN movie_event me ON e.evt_id = me.evt_id LEFT JOIN movie m ON me.movie_mve_id = m.mve_id " +
                " LEFT JOIN spc_event se ON e.evt_id = se.evt_id " +
                " LEFT JOIN lct_event le ON e.evt_id = le.evt_id  " +
                " LEFT JOIN msc_event mse ON e.evt_id = mse.evt_id " +
                " LEFT JOIN grp g ON (le.group_grp_id = g.grp_id OR mse.group_grp_id = g.grp_id OR se.authors_grp_id = g.grp_id) " +
                " LEFT JOIN person p ON se.director_prs_id = p.prs_id " +
                " LEFT JOIN picture pic ON e.picture_pic_id = pic.pic_id " +
                "WHERE to_tsvector(coalesce(evt_title,'') || ' ' || evt_date || ' ' || coalesce(evt_description,'') || ' ' || coalesce(evt_type,'') || ' ' || " +
                " coalesce(lct_name,'') || ' '  || coalesce(lct_description,'')|| ' ' || coalesce(cty_name,'') || ' ' || " +
                " coalesce(mve_name,'') || ' ' || coalesce(mve_janr,'') || ' ' || coalesce(mve_description,'') || ' ' || " +
                " coalesce(lct_category,'') || ' ' || " +
                " coalesce(grp_name,'') || ' ' || coalesce(grp_janr,'') || ' ' || " +
                " coalesce(prs_first_name,'') || ' ' || coalesce(prs_last_name,'') " +
                " ) @@ plainto_tsquery(?)";
        List<EventDTO> query = getJdbcTemplate().query(sql, new Object[]{text}, new EventMapper());
        return query;
    }

    public List<EventVisitsDTO> findEventVisits()
    {
        String sql =
            "SELECT e.evt_id, e.evt_title, e.evt_type, e.evt_price, l.lct_name," +
            "(SELECT COUNT(*) FROM usr_event ue WHERE ue.events_evt_id = e.evt_id) AS cnt, e.picture_pic_id " +
            "FROM event e LEFT JOIN location l ON e.location_lct_id = l.lct_id ORDER BY cnt DESC LIMIT 5";
        List<EventVisitsDTO> query = getJdbcTemplate().query(sql, new EventVisitsMapper());
        return query;
    }

    public List<EventMaxPriceDTO> findEventsByMaxPrice()
    {
        String sql =
            "SELECT DISTINCT e1.evt_id, e1.evt_title, e1.evt_price, c.cty_name, e1.picture_pic_id " +
            "FROM event e1 LEFT JOIN location l1 ON e1.location_lct_id = l1.lct_id " +
            "LEFT JOIN city c ON l1.city_cty_id = c.cty_id " +
            "RIGHT JOIN (" +
            "    SELECT l2.city_cty_id, MAX(e2.evt_price) as max_price " +
            "FROM event e2 JOIN location l2 ON e2.location_lct_id = l2.lct_id " +
            "GROUP BY l2.city_cty_id) price ON l1.city_cty_id = price.city_cty_id AND e1.evt_price = price.max_price " +
            "ORDER BY e1.evt_price DESC";

        List<EventMaxPriceDTO> query = getJdbcTemplate().query(sql, new EventMaxPriceMapper());
        return query;
    }

    public List<EventMaxPriceDTO> findEventsByMinPrice()
    {
        String sql =
                "SELECT DISTINCT e1.evt_id, e1.evt_title, e1.evt_price, c.cty_name " +
                        "FROM event e1 LEFT JOIN location l1 ON e1.location_lct_id = l1.lct_id " +
                        "LEFT JOIN city c ON l1.city_cty_id = c.cty_id " +
                        "RIGHT JOIN (" +
                        "    SELECT l2.city_cty_id, MIN(e2.evt_price) as max_price " +
                        "FROM event e2 JOIN location l2 ON e2.location_lct_id = l2.lct_id " +
                        "GROUP BY l2.city_cty_id) price ON l1.city_cty_id = price.city_cty_id AND e1.evt_price = price.max_price " +
                        "ORDER BY e1.evt_price DESC";

        List<EventMaxPriceDTO> query = getJdbcTemplate().query(sql, new EventMaxPriceMapper());
        return query;
    }

    public List<EventMaxPriceCatDTO> findEventsByMaxPriceGroupByCategory()
    {
        String sql =
                "SELECT DISTINCT e1.evt_id, e1.evt_title, e1.evt_type, e1.evt_price, c.cty_name " +
                "FROM event e1 LEFT JOIN location l1 ON e1.location_lct_id = l1.lct_id " +
                "LEFT JOIN city c ON l1.city_cty_id = c.cty_id " +
                "RIGHT JOIN (" +
                "SELECT l2.city_cty_id, e2.evt_type, MAX(e2.evt_price) as max_price " +
                "FROM event e2 JOIN location l2 ON e2.location_lct_id = l2.lct_id " +
                "GROUP BY e2.evt_type, l2.city_cty_id) price ON l1.city_cty_id = price.city_cty_id AND e1.evt_price = price.max_price " +
                "ORDER BY c.cty_name, e1.evt_price DESC";
        List<EventMaxPriceCatDTO> query = getJdbcTemplate().query(sql, new EventMaxPriceCatMapper());
        return query;
    }

    public List<EventMaxPriceCatDTO> findEventsByMinPriceGroupByCategory()
    {
        String sql =
                "SELECT DISTINCT e1.evt_id, e1.evt_title, e1.evt_type, e1.evt_price, c.cty_name " +
                        "FROM event e1 LEFT JOIN location l1 ON e1.location_lct_id = l1.lct_id " +
                        "LEFT JOIN city c ON l1.city_cty_id = c.cty_id " +
                        "RIGHT JOIN (" +
                        "SELECT l2.city_cty_id, e2.evt_type, MIN(e2.evt_price) as max_price " +
                        "FROM event e2 JOIN location l2 ON e2.location_lct_id = l2.lct_id " +
                        "GROUP BY e2.evt_type, l2.city_cty_id) price ON l1.city_cty_id = price.city_cty_id AND e1.evt_price = price.max_price " +
                        "ORDER BY c.cty_name, e1.evt_price";
        List<EventMaxPriceCatDTO> query = getJdbcTemplate().query(sql, new EventMaxPriceCatMapper());
        return query;
    }

    public List<LectureFinderDTO> findLeсturesByLecturerName(String lecturerName)
    {
        String sql =
                "SELECT e.evt_id, e.evt_title, e.evt_type FROM event e LEFT JOIN lct_event le ON e.evt_id = le.evt_id " +
                "WHERE e.evt_type = 'LECTURE' AND le.group_grp_id IN " +
                "(SELECT pg.groups_grp_id as grp_id " +
                "FROM person p " +
                "LEFT JOIN person_grp pg ON p.prs_id = pg.person_prs_id " +
                "WHERE p.prs_first_name || ' ' || p.prs_last_name LIKE %?% " +
                "AND pg.groups_grp_id IN (SELECT group_grp_id FROM lct_event))";
        List<LectureFinderDTO> query = getJdbcTemplate().query(sql, new Object[]{lecturerName}, new LectureFinderMapper());
        return query;
    }

    public List<UsersActivityDTO> findTopActivityUsers()
    {
        String sql =
                "SELECT u.usr_id, u.usr_login, u.usr_scn_name, u.usr_fst_name, u.usr_email, a.visits " +
                        "FROM usr u LEFT JOIN " +
                        "    (SELECT ue.users_usr_id, COUNT(*) as visits " +
                        "FROM usr_event ue LEFT JOIN usr u ON ue.users_usr_id = u.usr_id " +
                        "GROUP BY users_usr_id) " +
                        "a ON u.usr_id = a.users_usr_id " +
                        "ORDER BY a.visits, u.usr_scn_name, u.usr_fst_name " +
                        "LIMIT 5";
        List<UsersActivityDTO> query = getJdbcTemplate().query(sql, new Object[]{}, new UsersActivityMapper());
        return query;
    }


    public static void main(String[] args) {
        System.out.println("SELECT u.usr_id, u.usr_login, u.usr_scn_name, u.usr_fst_name, u.usr_email, a.visits " +
                "FROM usr u LEFT JOIN " +
                "    (SELECT ue.users_usr_id, COUNT(*) as visits " +
                "FROM usr_event ue LEFT JOIN usr u ON ue.users_usr_id = u.usr_id " +
                "GROUP BY users_usr_id) " +
                "a ON u.usr_id = a.users_usr_id " +
                "ORDER BY a.visits, u.usr_scn_name, u.usr_fst_name " +
                "LIMIT 5");
    }
}
