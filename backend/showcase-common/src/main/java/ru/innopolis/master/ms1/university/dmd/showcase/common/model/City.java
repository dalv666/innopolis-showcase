package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "CITY")
public class City implements Serializable {

    @Basic
    @Column(name = "CTY_NAME", nullable = false)
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "CTY_ID")
    private long id;

    @OneToOne
    private Picture picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
