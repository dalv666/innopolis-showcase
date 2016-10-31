package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by dalv on 30.10.2016.
 */
@Entity
@Table(name = "MSC_EVENT")
public class MusicConcertEvent extends Event {

    @ManyToOne
    private Group group;


}
