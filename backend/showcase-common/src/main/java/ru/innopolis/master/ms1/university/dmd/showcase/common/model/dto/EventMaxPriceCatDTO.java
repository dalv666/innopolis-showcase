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

}
