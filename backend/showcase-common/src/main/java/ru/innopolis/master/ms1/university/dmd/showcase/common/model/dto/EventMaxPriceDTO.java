package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventMaxPriceDTO {
    private long evt_id;
    private String evt_title;
    private double evt_price;
    private String lct_name;

    public EventMaxPriceDTO(long evt_id, String evt_title, double evt_price, String lct_name) {
        this.evt_id = evt_id;
        this.evt_title = evt_title;
        this.evt_price = evt_price;
        this.lct_name = lct_name;
    }
}
