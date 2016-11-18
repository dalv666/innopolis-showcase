package ru.innopolis.master.ms1.university.dmd.showcase.service.mapper;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventVisitsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EventVisitsMapper implements RowMapper<EventVisitsDTO> {

    public EventVisitsDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        long evt_id = resultSet.getLong(1);
        String evt_title = resultSet.getString(2);
        String evt_type = resultSet.getString(3);
        double evt_price = resultSet.getDouble(4);
        String lct_name = resultSet.getString(5);
        long visits = resultSet.getLong(6);
        return new EventVisitsDTO(evt_id, evt_title, evt_type, evt_price, lct_name, visits);
    }
}
