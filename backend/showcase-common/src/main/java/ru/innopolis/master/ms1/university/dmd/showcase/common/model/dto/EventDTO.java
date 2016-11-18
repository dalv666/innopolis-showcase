package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;


/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventDTO {

    private long id;
    private String title;
    private String type;
    private String pic_link;
    private long duration;
    private double price;
    private String lct_name;
    private String cty_name;

    public EventDTO(long id, String title, String type, String pic_link, long duration, double price, String lct_name, String cty_name) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.pic_link = pic_link;
        this.duration = duration;
        this.price = price;
        this.lct_name = lct_name;
        this.cty_name = cty_name;
    }
}
