package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.*;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.EventDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.EventDAOCustom;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.UserDAOCustom;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom.impl.EventDAOImpl;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.EventService;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private EventDAOImpl eventDaoImpl;

    @Autowired
    private UserDAOCustom userDao;


    public Event create(Event object) {
        return eventDAO.save(object);
    }


    public Event delete(Long roomId) {
        Event event = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        eventDAO.delete(event);
        return event;
    }

    public List<Event> findAll() {
        return (List<Event>) eventDAO.findAll();
    }

    public Event findById(Long objectId) {
        return eventDAO.findOne(objectId);
    }

    public Event update(Event object) {
        Event event = eventDAO.findOne(object.getId());
/*        if (event == null) {
            throw new NotFoundException(event.getId(), Room.class);
        }*/
        return eventDAO.save(event);
    }

    @Override
    public List<User> getEventMembers(long eventId, int pageNumber, int pageSize) {
        Event event = eventDAO.findOne(eventId);
/*        if (event == null) {
            throw new NotFoundException(eventId, Event.class);
        }*/
        Page<User> page = eventDAO.getEventUsers(event, new PageRequest(pageNumber, pageSize));
        return page.getContent();
    }

    @Override
    public void userGoEvent(long userId, long eventId) {
        userDao.userGoEvent(userId, eventId);
    }

    @Override
    public boolean isUserGoEvent(long userId, long eventId) {
        return userDao.isUserGoEvent(userId, eventId);
    }

    @Override
    public void userNoGoEvent(long userId, long eventId) {
        userDao.userNoGoEvent(userId, eventId);
    }

    @Override
    public List<EventDTO> findEventsByFilters(String title, String cityName, long price, String date) {
        return eventDaoImpl.findEventsByFilters(title, cityName, price, date);
    }

    @Override
    public List<EventVisitsDTO> findEventVisits() {
        return eventDaoImpl.findEventVisits();
    }

    @Override
    public List<EventMaxPriceDTO> findEventsByMaxPrice() {
        return eventDaoImpl.findEventsByMaxPrice();
    }

    @Override
    public List<EventMaxPriceDTO> findEventsByMinPrice() {
        return eventDaoImpl.findEventsByMinPrice();
    }

    @Override
    public List<EventMaxPriceCatDTO> findEventsByMaxPriceGroupByCategory() {
        return eventDaoImpl.findEventsByMaxPriceGroupByCategory();
    }

    @Override
    public List<EventMaxPriceCatDTO> findEventsByMinPriceGroupByCategory() {
        return eventDaoImpl.findEventsByMinPriceGroupByCategory();
    }

    @Override
    public List<LectureFinderDTO> findLeсturesByLecturerName(String lecturerName) {
        return eventDaoImpl.findLeсturesByLecturerName(lecturerName);
    }

    @Override
    public List<UsersActivityDTO> findTopActivityUsers(long topCount) {
        return eventDaoImpl.findTopActivityUsers(topCount);
    }

}
