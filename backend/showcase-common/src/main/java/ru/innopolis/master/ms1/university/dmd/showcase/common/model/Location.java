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

}
