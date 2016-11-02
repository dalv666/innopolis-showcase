package ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom;

/**
 * Created by dalv on 01.11.2016.
 */
public interface UserDAOCustom {

    void userGoEvent(long userId, long eventId);
    void userNoGoEvent(long userId, long eventId);

    boolean isUserGoEvent(long userId, long eventId);

}
