package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by dalv on 31.10.2016.
 */
@RestController
@CrossOrigin
public class SessionController {

    @PostMapping("/sessions/create")
    public String session(@RequestBody String body) {
        System.out.println(body);
        return "{ \"id_token\" : 228}";
    }
}
