package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "MVE_ID")
    private long id;

    @Basic
    @Column(name = "MVE_NAME")
    private String name;

    @Basic
    @Column(name = "MVE_CREATED")
    private LocalDate created;

    @Basic
    @Column(name = "MVE_JANR")
    private String janr;

    @Basic
    @Column(name = "MVE_DESCRIPTION")
    private String description;

    @OneToOne
    private Picture picture;

    public Movie(long id, String name, LocalDate created, String janr, String description, Picture picture) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.janr = janr;
        this.description = description;
        this.picture = picture;
    }

    public Movie() {
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getJanr() {
        return janr;
    }

    public void setJanr(String janr) {
        this.janr = janr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
