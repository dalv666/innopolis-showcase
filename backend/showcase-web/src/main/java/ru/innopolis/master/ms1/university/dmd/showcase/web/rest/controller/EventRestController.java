package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.*;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.EventService;

import java.util.ArrayList;
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

    @GetMapping("/event/attend/stat")
    public List getEventStatAttendStat() {
        EventVisitsDTO eventVisitsDTO = new EventVisitsDTO(1, "LUX", "GE", 123d, "DIGA", 225);
        EventVisitsDTO eventVisitsDTO2 = new EventVisitsDTO(1, "LUX", "GE", 123d, "DIGA", 225);
        ArrayList<EventVisitsDTO> eventVisitsDTOs = new ArrayList<EventVisitsDTO>();
        eventVisitsDTOs.add(eventVisitsDTO);
        eventVisitsDTOs.add(eventVisitsDTO2);
        return eventVisitsDTOs;
    }



    @GetMapping("/event/max/city")
    public List getEventMaxPriceCityDTO() {
        List<EventMaxPriceDTO> eventVisitsDTOs = eventService.findEventsByMaxPrice();
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
    public List getUsersActivityDTO(long topCount) {
        List<UsersActivityDTO> usersActivityDTOs = eventService.findTopActivityUsers(topCount);
        return usersActivityDTOs;
    }


    @GetMapping("/event/search")
    public List findEventsByFilters(String title, String cityName, long price, String category){
        List<EventDTO> eventDTOs = eventService.findEventsByFilters(title, cityName, price, category);
        return eventDTOs;
    }

    @GetMapping("/event/lecture/search/by_author")
    public List<LectureFinderDTO> findLeсturesByLecturerName(String lecturerName)
    {
        List<LectureFinderDTO> lectureFinderDTOs = eventService.findLeсturesByLecturerName(lecturerName);
        return lectureFinderDTOs;
    }

    @GetMapping("/event/visits")
    public List<EventVisitsDTO> findEventVisits()
    {
        List<EventVisitsDTO> eventVisitsDTOs = eventService.findEventVisits();
        return eventVisitsDTOs;
    }
}
