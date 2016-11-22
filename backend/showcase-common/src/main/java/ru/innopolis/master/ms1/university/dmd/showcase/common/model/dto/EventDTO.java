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
    private String description;
    private long capacity;
    private long duration;
    private double price;
    private String lct_name;
    private String cty_name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPic_link() {
        return pic_link;
    }

    public void setPic_link(String pic_link) {
        this.pic_link = pic_link;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLct_name() {
        return lct_name;
    }

    public void setLct_name(String lct_name) {
        this.lct_name = lct_name;
    }

    public String getCty_name() {
        return cty_name;
    }

    public void setCty_name(String cty_name) {
        this.cty_name = cty_name;
    }

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
