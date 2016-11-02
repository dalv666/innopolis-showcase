package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "LCT_ID")
    private long id;

    @Basic
    @Column(name = "LCT_NAME", nullable = false)
    private String name;

    @Basic
    @Column(name = "LCT_LONGITUDE")
    private long longitude;

    @Basic
    @Column(name = "LCT_LATITUDE")
    private long latitude;

    @Basic
    @Column(name = "LCT_DESCRIPTION")
    private String description;

    @OneToOne
    private City city;

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

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Location(long id, String name, long longitude, long latitude, String description, City city) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
        this.city = city;
    }

    public Location() {
    }
}
