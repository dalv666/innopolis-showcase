package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;

import java.io.Serializable;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventMaxPriceDTO implements Serializable {
    private long evt_id;
    private String evt_title;
    private double evt_price;
    private String lct_name;
    private long pic_id;
    private String pic_url;

    public long getPic_id() {
        return pic_id;
    }

    public void setPic_id(long pic_id) {
        this.pic_id = pic_id;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public EventMaxPriceDTO(long evt_id, String evt_title, double evt_price, String lct_name) {
        this.evt_id = evt_id;
        this.evt_title = evt_title;
        this.evt_price = evt_price;
        this.lct_name = lct_name;
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
}
