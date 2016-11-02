package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "MOVIE_EVENT")
public class MovieEvent extends Event {

    @Id
    @GeneratedValue
    @Column(name = "MVT_ID")
    private long id;

    @Basic
    @Column(name = "MVT_SCREEN_TYPE")
    private String typeScreen;

    @Basic
    @Column(name = "MVT_LANGUAGE")
    private String language;

    @ManyToOne
    private Movie movie;


    public MovieEvent() {
    }

    public MovieEvent(long id, LocalDate date, int capacity, String title, double price, long duration, String description, Location location, Picture picture, String type, String typeScreen, String language, Movie movie) {
        super(id, date, capacity, title, price, duration, description, location, picture, type);
        this.typeScreen = typeScreen;
        this.language = language;
        this.movie = movie;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTypeScreen() {
        return typeScreen;
    }

    public void setTypeScreen(String typeScreen) {
        this.typeScreen = typeScreen;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
