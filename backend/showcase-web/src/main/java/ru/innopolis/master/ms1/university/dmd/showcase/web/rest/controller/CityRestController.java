package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.City;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.CityService;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List getCities() {
        List<City> all = cityService.findAll();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/city/{id}")
    public City getCustomers(@PathVariable long id) {
        return cityService.findById(id);
    }

}
