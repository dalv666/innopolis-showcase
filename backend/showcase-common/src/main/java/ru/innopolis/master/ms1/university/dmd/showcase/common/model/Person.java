package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "PRS_ID")
    private long id;

    @Basic
    @Column(name = "PRS_FIRST_NAME")
    private String firstName;

    @Basic
    @Column(name = "PRS_LAST_NAME")
    private String lastName;

    @Basic
    @Column(name = "PRS_DEATH")
    private LocalDate deaathDate;

    @Basic
    @Column(name = "PRS_BIRTHDAY")
    private LocalDate birthdayDate;

    @OneToOne
    private Picture photo;

    @Basic
    @Column(name = "PRS_DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Award> awards;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Group> groups;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> rating;

    public Person(long id, String firstName, String lastName, LocalDate deaathDate, LocalDate birthdayDate, Picture photo, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deaathDate = deaathDate;
        this.birthdayDate = birthdayDate;
        this.photo = photo;
        this.description = description;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Picture getPhoto() {
        return photo;
    }

    public void setPhoto(Picture photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
