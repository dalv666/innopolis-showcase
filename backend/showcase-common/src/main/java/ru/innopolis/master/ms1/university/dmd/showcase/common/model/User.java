package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by dalv on 24.10.2016.
 */

@Entity
@Table(name = "USR")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USR_ID")
    private long id;

    @Basic
    @Column(name = "USR_FST_NAME", nullable = true)
    private String firstName;

    @Basic
    @Column(name = "USR_SCN_NAME", nullable = true)
    private String secondName;

    @Basic
    @Column(name = "USR_LOGIN", nullable = false, unique = true)
    private String login;

    @Basic
    @Column(name = "USR_PASSWORD", nullable = false)
    private String password;

    @Basic
    @Column(name = "USR_REGISTRATION")
    private LocalDate regDate;

    @Basic
    @Column(name = "USR_EMAIL", nullable = false)
    private String email;

    @OneToOne
    private Picture avatar;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Event> events;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", email='" + email + '\'' +
                ", avatar=" + avatar +
                '}';
    }

    public User(long id, String firstName, String secondName, String login, String password, LocalDate regDate, String email, Picture avatar) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.regDate = regDate;
        this.email = email;
        this.avatar = avatar;
    }

    public User() {
    }

    public Picture getAvatar() {
        return avatar;
    }

    public void setAvatar(Picture avatar) {
        this.avatar = avatar;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
