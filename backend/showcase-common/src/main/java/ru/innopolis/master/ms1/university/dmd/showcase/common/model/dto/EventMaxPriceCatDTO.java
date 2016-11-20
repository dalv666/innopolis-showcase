package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventMaxPriceCatDTO {
    private long evt_id;
    private String evt_title;
    private String evt_type;
    private double evt_price;
    private String cty_name;

    public EventMaxPriceCatDTO(long evt_id, String evt_title, String evt_type, double evt_price, String cty_name) {
        this.evt_id = evt_id;
        this.evt_title = evt_title;
        this.evt_type = evt_type;
        this.evt_price = evt_price;
        this.cty_name = cty_name;
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

    public String getCty_name() {
        return cty_name;
    }

    public void setCty_name(String cty_name) {
        this.cty_name = cty_name;
    }
}
