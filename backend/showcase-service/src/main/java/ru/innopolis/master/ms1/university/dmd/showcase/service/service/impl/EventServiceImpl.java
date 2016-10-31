package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.EventDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.EventService;

import java.util.List;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;


    public Event create(Event object) {
        return eventDAO.save(object);
    }

    public Event delete(Long objectId) {
        return null;
    }

    public List<Event> findAll() {
        return (List<Event>) eventDAO.findAll();
    }

    public Event findById(Long objectId) {
        return eventDAO.findOne(objectId);
    }

    public Event update(Event object) {
        return null;
    }


}
