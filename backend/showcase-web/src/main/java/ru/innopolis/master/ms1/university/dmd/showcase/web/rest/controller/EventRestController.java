package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Picture;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.*;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.EventService;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.PictureService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class EventRestController {

    @Autowired
    private EventService eventService;

    @Autowired
    private PictureService pictureService;

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
        return eventService.findEventsByFilters("e", "name", 1l);
    }


    @GetMapping("/event/max/city")
    public List getEventMaxPriceCityDTO() {
        List<EventMaxPriceDTO> eventVisitsDTOs = eventService.findEventsByMaxPrice();
        for (EventMaxPriceDTO eventVisitsDTO : eventVisitsDTOs) {
            Picture byId = pictureService.findById(eventVisitsDTO.getPic_id());
            eventVisitsDTO.setPic_url(byId.getPicture());
        }
        return eventVisitsDTOs;
    }

    @GetMapping("/event/min/city")
    public List getEventMinPriceCityDTO() {
        List<EventMaxPriceDTO> eventVisitsDTOs = eventService.findEventsByMinPrice();
        return eventVisitsDTOs;
    }


    @GetMapping("/event/max/cat")
    public List getEventMaxPriceCatDTO() {
        List<EventMaxPriceCatDTO> eventMaxPriceCatDTOs = eventService.findEventsByMaxPriceGroupByCategory();
        return eventMaxPriceCatDTOs;
    }

    @GetMapping("/event/min/cat")
    public List getEventMinPriceCatDTO() {
        List<EventMaxPriceCatDTO> eventMinPriceCatDTOs = eventService.findEventsByMinPriceGroupByCategory();
        return eventMinPriceCatDTOs;
    }


    @GetMapping("/user/actives")
    public List getUsersActivityDTO() {
        List<UsersActivityDTO> usersActivityDTOs = eventService.findTopActivityUsers();
        return usersActivityDTOs;
    }


    @GetMapping("/event/search/{title}/{city}/{maxPrice}")
    public List findEventsByFilters(@PathVariable String title, @PathVariable String city, @PathVariable Long maxPrice) {
        if (title == null) {
            title = "";
        }
        if (city == null) {
            city = "";
        }
        if (maxPrice == null) {
            maxPrice = Long.MAX_VALUE;
        }

        List<EventDTO> eventDTOs = eventService.findEventsByFilters(title, city, maxPrice);
        return eventDTOs;
    }


    @GetMapping("/event/lecture/search/by_author")
    public List<LectureFinderDTO> findLeсturesByLecturerName(String lecturerName) {
        List<LectureFinderDTO> lectureFinderDTOs = eventService.findLeсturesByLecturerName(lecturerName);
        return lectureFinderDTOs;
    }

    @GetMapping("/event/attend/stat")
    public List<EventVisitsDTO> findEventVisits() {
        List<EventVisitsDTO> eventVisitsDTOs = eventService.findEventVisits();
        for (EventVisitsDTO eventVisitsDTO : eventVisitsDTOs) {
            Picture byId = pictureService.findById(eventVisitsDTO.getPic_id());
            eventVisitsDTO.setPic_url(byId.getPicture());
        }
        return eventVisitsDTOs;
    }

    @GetMapping("/search/{search}")
    public List<EventDTO> search(@PathVariable String search) {
        return eventService.searchEvent(search);
    }
}
