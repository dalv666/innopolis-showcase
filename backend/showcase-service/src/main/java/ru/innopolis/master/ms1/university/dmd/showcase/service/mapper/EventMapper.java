package ru.innopolis.master.ms1.university.dmd.showcase.service.mapper;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventDTO;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EventMapper implements RowMapper<EventDTO> {

    public EventDTO mapRow(ResultSet resultSet, int i) throws SQLException {

        long id = resultSet.getLong(1);
        String title = resultSet.getString(2);
        String type = resultSet.getString(3);
        Double price = resultSet.getDouble(4);
        long duration = resultSet.getLong(5);
        String pic_link = resultSet.getString(6);
        String lct_name = resultSet.getString(7);
        String cty_name = resultSet.getString(8);
        String desc = resultSet.getString(9);
        long cap = resultSet.getLong(10);
        EventDTO eventDTO = new EventDTO(id, title, type, pic_link, duration, price, lct_name, cty_name);
        eventDTO.setDescription(desc);
        eventDTO.setCapacity(cap);
        return eventDTO;
    }
}
