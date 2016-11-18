package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class LectureFinderDTO {
    private long evt_id;
    private String evt_title;
    private String evt_type;

    public LectureFinderDTO(long evt_id, String evt_title, String evt_type) {
        this.evt_id = evt_id;
        this.evt_title = evt_title;
        this.evt_type = evt_type;
    }
}
