package ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Movie;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.EventDAOCustom;
import ru.innopolis.master.ms1.university.dmd.showcase.service.mapper.EventMapper;

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
                "FROM movie m\n" +
                "WHERE (SELECT count(*)\n" +
                "  FROM movie_starred ms\n" +
                "  WHERE ms.movie_mve_id = m.mve_id)\n" +
                "  =\n" +
                "  (SELECT count(*)\n" +
                "  FROM person p LEFT JOIN \n" +
                "    (SELECT pr.person_prs_id AS prs_id, AVG(pr.rating) AS avg_rate FROM person_rate pr GROUP BY prs_id) rates ON p.prs_id = rates.prs_id LEFT JOIN\n" +
                "    (SELECT pa.person_prs_id AS prs_id, COUNT(*) AS award_count FROM person_award pa GROUP BY prs_id) awards ON p.prs_id = awards.prs_id\n" +
                "      WHERE (rates.avg_rate >= ? OR awards.award_count >= 1) AND p.prs_id IN \n" +
                "        (SELECT ms.person_prs_id FROM movie_starred ms WHERE ms.movie_mve_id = m.mve_id)) \n" +
                "  AND m.mve_created >= '?'");
        nativeQuery.setParameter(1, rate);
        nativeQuery.setParameter(2, date);
        nativeQuery.executeUpdate();
        return nativeQuery.getResultList();
    }

    public List<EventDTO> findEventsByFilters(String title, String cityName, long price, String date) {

        String sql = "SELECT e.evt_title, e.evt_type, e.evt_price, e.evt_duration, p.pic_link, l.lct_name, c.cty_name \n" +
                "FROM event e LEFT JOIN location l ON e.location_lct_id = l.lct_id " +
                "LEFT JOIN picture p ON e.picture_pic_id = p.pic_id " +
                "LEFT JOIN city c ON l.city_cty_id = c.cty_id " +
                "WHERE e.evt_title LIKE '%?%' AND " +
                "c.cty_name = '?' AND" +
                "e.evt_price <= ? AND" +
                "(e.evt_date = '?' OR CURRENT_DATE)";
        List<EventDTO> query = getJdbcTemplate().query(sql, new Object[]{title, cityName, price, date}, new EventMapper());
        return query;
    }

}
