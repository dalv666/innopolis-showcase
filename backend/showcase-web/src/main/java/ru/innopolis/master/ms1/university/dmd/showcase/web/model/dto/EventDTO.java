package ru.innopolis.master.ms1.university.dmd.showcase.web.model.dto;


import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Location;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Movie;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;

import java.time.LocalDate;
import java.util.Set;

public class EventDTO{

    private long id;

    private LocalDate date;

    private int capacity;

    private String title;

    private double price;

    private long duration;


    private Location location;

    private Set<User> peoples;

    private String typeScreen;

    private String language;

    private Movie movie;

}
