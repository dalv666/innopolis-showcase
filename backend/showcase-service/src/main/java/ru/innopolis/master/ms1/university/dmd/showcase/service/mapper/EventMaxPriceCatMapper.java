package ru.innopolis.master.ms1.university.dmd.showcase.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventMaxPriceCatDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventMaxPriceCatMapper implements RowMapper<EventMaxPriceCatDTO> {
    public EventMaxPriceCatDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        long evt_id = resultSet.getLong(1);
        String evt_title = resultSet.getString(2);
        String evt_type = resultSet.getString(3);
        double evt_price = resultSet.getDouble(4);
        String cty_name = resultSet.getString(5);

        return new EventMaxPriceCatDTO(evt_id, evt_title, evt_type, evt_price, cty_name);
    }

}
