package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dalv on 24.10.2016.
 */
@Entity
@Table(name = "SPC_EVENT")
public class SpectacleEvent extends Event {
    //TODO: END IT
    @ManyToOne
    private Person director;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> authors;

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

}
