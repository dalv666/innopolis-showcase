package ru.innopolis.master.ms1.university.dmd.showcase.service.mapper;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.UsersActivityDTO;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersActivityMapper implements RowMapper<UsersActivityDTO> {

    public UsersActivityDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        long usr_id = resultSet.getLong(1);
        String usr_name = resultSet.getString(2);
        String usr_scn_name = resultSet.getString(3);
        String usr_fst_name = resultSet.getString(4);
        String usr_email = resultSet.getString(5);
        long visits = resultSet.getLong(6);

        return new UsersActivityDTO(usr_id, usr_name, usr_scn_name, usr_fst_name, usr_email, visits);
    }
}
