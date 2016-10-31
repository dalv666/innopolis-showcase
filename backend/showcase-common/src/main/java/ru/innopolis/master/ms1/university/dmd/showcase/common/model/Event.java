package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "EVENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Event implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EVT_ID")
    private long id;

    @Basic
    @Column(name = "EVT_DATE", nullable = false)
    private LocalDate date;

    @Basic
    @Column(name = "EVT_CAPACITY", nullable = false)
    private int capacity;

    @Basic
    @Column(name = "EVT_TITLE", nullable = false)
    private String title;

    @Basic
    @Column(name = "EVT_PRICE", nullable = false)
    private double price;

    @Basic
    @Column(name = "EVT_DURATION")
    private long duration;

    @Basic
    @Column(name = "EVT_DESCRIPTION")
    private String description;

    @OneToOne
    private Location location;

    @OneToOne
    private Picture picture;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "events")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}
