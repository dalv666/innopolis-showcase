package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Location;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.LocationService;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class LocationRestController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List getLocations() {
        List<Location> all = locationService.findAll();
        Collections.shuffle(all);
        return all;
    }

    @GetMapping("/location/{id}")
    public Location getLocation(@PathVariable long id) {
        return locationService.findById(id);
    }

}
