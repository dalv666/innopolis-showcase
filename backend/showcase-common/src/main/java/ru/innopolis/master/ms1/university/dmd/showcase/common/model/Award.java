package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "AWARD")
public class Award implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "AWD_ID")
    private long id;

    @Basic
    @Column(name = "AWD_NAME", nullable = false)
    private String name;

    @Basic
    @Column(name = "AWD_DATE", nullable = false)
    private LocalDate date;

    public Award(long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Award() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
