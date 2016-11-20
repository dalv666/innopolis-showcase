package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;

import java.io.Serializable;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventVisitsDTO implements Serializable {
    private long evt_id;
    private String evt_title;
    private String evt_type;
    private double evt_price;
    private String lct_name;
    private long visits;

    public EventVisitsDTO(long evt_id, String evt_title, String evt_type, double evt_price, String lct_name, long visits) {
        this.evt_id = evt_id;
        this.evt_title = evt_title;
        this.evt_type = evt_type;
        this.evt_price = evt_price;
        this.lct_name = lct_name;
        this.visits = visits;
    }

    public long getEvt_id() {
        return evt_id;
    }

    public void setEvt_id(long evt_id) {
        this.evt_id = evt_id;
    }

    public String getEvt_title() {
        return evt_title;
    }

    public void setEvt_title(String evt_title) {
        this.evt_title = evt_title;
    }

    public String getEvt_type() {
        return evt_type;
    }

    public void setEvt_type(String evt_type) {
        this.evt_type = evt_type;
    }

    public double getEvt_price() {
        return evt_price;
    }

    public void setEvt_price(double evt_price) {
        this.evt_price = evt_price;
    }

    public String getLct_name() {
        return lct_name;
    }

    public void setLct_name(String lct_name) {
        this.lct_name = lct_name;
    }

    public long getVisits() {
        return visits;
    }

    public void setVisits(long visits) {
        this.visits = visits;
    }
}
