package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "PICTURE")
public class Picture implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "PIC_ID")
    private long id;

    @Basic
    @Column(name = "PIC_LINK")
    private String picture;

    public Picture(long id, String picture) {
        this.id = id;
        this.picture = picture;
    }

    public Picture() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
