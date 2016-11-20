package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by dalv on 31.10.2016.
 */
@RestController
@CrossOrigin
public class SessionController {


    @PostMapping("/sessions/create")
    public boolean session(@RequestBody Usr body) {
        if (body.username.equals("user") && body.password.equals("user")) {
            return true;
        } else {
            return false;
        }
    }
}
