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

    public long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(long usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getUsr_scn_name() {
        return usr_scn_name;
    }

    public void setUsr_scn_name(String usr_scn_name) {
        this.usr_scn_name = usr_scn_name;
    }

    public String getUsr_fst_name() {
        return usr_fst_name;
    }

    public void setUsr_fst_name(String usr_fst_name) {
        this.usr_fst_name = usr_fst_name;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    public long getVisits() {
        return visits;
    }

    public void setVisits(long visits) {
        this.visits = visits;
    }
}
