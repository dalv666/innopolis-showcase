package ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class UsersActivityDTO {
    private long usr_id;
    private String usr_name;
    private String usr_scn_name;
    private String usr_fst_name;
    private String usr_email;
    private long visits;

    public UsersActivityDTO(long usr_id, String usr_name, String usr_scn_name, String usr_fst_name, String usr_email, long visits) {
        this.usr_id = usr_id;
        this.usr_name = usr_name;
        this.usr_scn_name = usr_scn_name;
        this.usr_fst_name = usr_fst_name;
        this.usr_email = usr_email;
        this.visits = visits;
    }
}
