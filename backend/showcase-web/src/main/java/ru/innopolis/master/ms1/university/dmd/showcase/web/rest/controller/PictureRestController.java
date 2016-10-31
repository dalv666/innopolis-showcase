package ru.innopolis.master.ms1.university.dmd.showcase.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Picture;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.PictureService;

import java.util.List;

@RestController
@CrossOrigin
public class PictureRestController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public List getAllPictures() {
        return pictureService.findAll();
    }

    @GetMapping("/picture/{id}")
    public Picture getPicture(@PathVariable long id) {
        return pictureService.findById(id);
    }

    @PostMapping("/pictures")
    public Picture savePicture(@RequestBody Picture picture) {
        return pictureService.create(picture);
    }

}
