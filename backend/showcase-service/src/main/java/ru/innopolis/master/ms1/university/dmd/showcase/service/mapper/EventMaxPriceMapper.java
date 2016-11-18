package ru.innopolis.master.ms1.university.dmd.showcase.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventMaxPriceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */
public class EventMaxPriceMapper implements RowMapper<EventMaxPriceDTO> {

    public EventMaxPriceDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        long evt_id = resultSet.getLong(1);
        String evt_title = resultSet.getString(2);
        double evt_price = resultSet.getDouble(3);
        String lct_name = resultSet.getString(4);

        return new EventMaxPriceDTO(evt_id, evt_title, evt_price, lct_name);
    }

}