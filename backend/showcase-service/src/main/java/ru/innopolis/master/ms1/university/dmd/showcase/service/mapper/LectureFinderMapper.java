package ru.innopolis.master.ms1.university.dmd.showcase.service.mapper;

/**
 * Created by Dmitry Mordovtsev on 18.11.16.
 * Innopolis University Masters Program
 * Group: MS1-2 (Big Data)
 */

import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.LectureFinderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LectureFinderMapper implements RowMapper<LectureFinderDTO> {

    public LectureFinderDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        long evt_id = resultSet.getLong(1);
        String evt_title = resultSet.getString(2);
        String evt_type = resultSet.getString(3);
        return new LectureFinderDTO(evt_id, evt_title, evt_type);
    }
}
