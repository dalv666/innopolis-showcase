package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "SPC_EVENT")
public class SpectacleEvent extends Event {

    @ManyToOne
    private Person director;

    @ManyToOne
    private Group authors;


    public SpectacleEvent(long id, LocalDate date, int capacity, String title, double price, long duration, String description, Location location, Picture picture, Person director, String type) {
        super(id, date, capacity, title, price, duration, description, location, picture, type);
        this.director = director;
    }

    public Group getAuthors() {
        return authors;
    }

    public void setAuthors(Group authors) {
        this.authors = authors;
    }

    public SpectacleEvent() {
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

}
