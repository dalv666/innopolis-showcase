package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventMaxPriceCatDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventMaxPriceDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventVisitsDTO;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.UsersActivityDTO;
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

        EventMaxPriceDTO eventMaxPriceDTO = new EventMaxPriceDTO(1, "max", 12d, "HOME");
        EventMaxPriceDTO eventMaxPriceDTO2 = new EventMaxPriceDTO(1, "max", 12d, "HOME");
        ArrayList<EventMaxPriceDTO> eventVisitsDTOs = new ArrayList<EventMaxPriceDTO>();
        eventVisitsDTOs.add(eventMaxPriceDTO);
        eventVisitsDTOs.add(eventMaxPriceDTO2);
        return eventVisitsDTOs;
    }


    @GetMapping("/event/max/cat")
    public List getEventMaxPriceCatDTO() {
        EventMaxPriceCatDTO eventMaxPriceCatDTO = new EventMaxPriceCatDTO(1, "TITLE", "TYPE", 12d, "CITY NAME");
        EventMaxPriceCatDTO eventMaxPriceCatDTO2 = new EventMaxPriceCatDTO(1, "TITLE", "TYPE", 12d, "CITY NAME");
        ArrayList<EventMaxPriceCatDTO> eventMaxPriceCatDTOs = new ArrayList<EventMaxPriceCatDTO>();
        eventMaxPriceCatDTOs.add(eventMaxPriceCatDTO);
        eventMaxPriceCatDTOs.add(eventMaxPriceCatDTO2);
        return eventMaxPriceCatDTOs;
    }


    @GetMapping("/user/actives")
    public List getUsersActivityDTO() {
        UsersActivityDTO usersActivityDTO = new UsersActivityDTO(1, "USR_NAME", "sec_NAME", "fst_name", "mail", 100l);
        UsersActivityDTO usersActivityDTO2 = new UsersActivityDTO(1, "USR_NAME", "sec_NAME", "fst_name", "mail", 100l);
        UsersActivityDTO usersActivityDTO3 = new UsersActivityDTO(1, "USR_NAME", "sec_NAME", "fst_name", "mail", 100l);
        ArrayList<UsersActivityDTO> usersActivityDTOs = new ArrayList<UsersActivityDTO>();
        usersActivityDTOs.add(usersActivityDTO);
        usersActivityDTOs.add(usersActivityDTO2);
        usersActivityDTOs.add(usersActivityDTO3);
        return usersActivityDTOs;
    }

    public List findEventsByFilters(String title, String cityName, long price, String category){


        return null;
    }
}
