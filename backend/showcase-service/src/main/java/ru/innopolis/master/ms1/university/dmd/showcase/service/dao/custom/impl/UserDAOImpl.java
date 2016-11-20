package ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.impl;


import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.LectureFinderDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.UsersActivityDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.UserDAOCustom;
import ru.innopolis.master.ms1.university.dmd.showcase.service.mapper.LectureFinderMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.service.mapper.UsersActivityMapper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by dalv on 01.11.2016.
 */
@Repository
public class UserDAOImpl implements UserDAOCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void userGoEvent(long userId, long eventId) {
        Query nativeQuery = entityManager.createNativeQuery("INSERT INTO usr_event(users_usr_id,events_evt_id) VALUES (?,?)");
        nativeQuery.setParameter(1, userId);
        nativeQuery.setParameter(2, eventId);
        nativeQuery.executeUpdate();
    }

    @Override
    public void userNoGoEvent(long userId, long eventId) {
        Query nativeQuery = entityManager.createNativeQuery("DELETE FROM usr_event where users_usr_id=? AND events_evt_id=?");
        nativeQuery.setParameter(1,userId);
        nativeQuery.setParameter(2,eventId);
        nativeQuery.executeUpdate();
    }

    @Override
    public boolean isUserGoEvent(long userId, long eventId) {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM usr_event WHERE users_usr_id=? AND events_evt_id=?");
        nativeQuery.setParameter(1, userId);
        nativeQuery.setParameter(2, eventId);
        List list = nativeQuery.getResultList();
        if (list.size() == 0) {
            return false;
        }
        return true;

    }
}
