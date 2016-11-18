package ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Movie;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.EventDAOCustom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by dalv on 02.11.2016.
 */
public class EventDAOImpl implements EventDAOCustom {


    @Autowired
    private EntityManager entityManager;

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



}
