package ru.innopolis.master.ms1.university.dmd.showcase.service.service;

import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.common.GenericCRUD;

import java.util.List;

public interface EventService extends GenericCRUD<Event> {

    List<User> getEventMembers(long eventId, int pageNumber, int pageSize);

    void userGoEvent(long userId, long eventId);

    boolean isUserGoEvent(long userId, long eventId);

    void userNoGoEvent(long userId, long eventId);

    List<EventDTO> findEventsByFilters(String title, String cityName, long price, String date);
}
