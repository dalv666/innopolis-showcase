package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.EventService;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class EventRestController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List getCustomers() {
        List<Event> all = eventService.findAll();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/event/{id}")
    public Event getCustomers(@PathVariable long id) {
        return eventService.findById(id);
    }


    @GetMapping("/event/{id}/users/")
    public List getUsers(@PathVariable long id) {
        return eventService.getEventMembers(id, 0, 20);
    }


    @GetMapping("/event/filter/")
    public List getFilteredEvents() {
        return eventService.findEventsByFilters("e", "name", 1, null);
    }

}
