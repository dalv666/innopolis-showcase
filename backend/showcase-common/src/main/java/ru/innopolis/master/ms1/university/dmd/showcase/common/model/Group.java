package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "GRP")
public class Group implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "GRP_ID")
    private long id;

    @Basic
    @Column(name = "GRP_NAME")
    private String name;

    @Basic
    @Column(name = "GRP_DATE")
    private LocalDate date;

    @Basic
    @Column(name = "GRP_JANR")
    private String janr;

    @OneToMany
    private Set<Award> awards;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Person> persons;

    @OneToOne
    private Picture picture;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getJanr() {
        return janr;
    }

    public void setJanr(String janr) {
        this.janr = janr;
    }

    public Set<Award> getAwards() {
        return awards;
    }

    public void setAwards(Set<Award> awards) {
        this.awards = awards;
    }
}
