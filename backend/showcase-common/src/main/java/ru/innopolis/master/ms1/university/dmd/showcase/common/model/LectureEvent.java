package ru.innopolis.master.ms1.university.dmd.showcase.common.model;

import javax.persistence.*;

/**
 * Created by dalv on 30.10.2016.
 */
@Entity
@Table(name = "LCT_EVENT")
public class LectureEvent extends Event {

    @Basic
    @Column(name = "LCT_CATEGORY")
    private String category;

    @ManyToOne
    private Group group;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public void setGroup(Group group) {
        this.group = group;
    }
}
