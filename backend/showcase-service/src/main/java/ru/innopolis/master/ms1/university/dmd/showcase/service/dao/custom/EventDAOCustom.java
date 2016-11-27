package ru.innopolis.master.ms1.university.dmd.showcase.service.dao.custom;

import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Movie;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.dto.EventDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by dalv on 01.11.2016.
 */
public interface EventDAOCustom {

    List<Movie> findMovieByAwardCountAndDate(double rate, LocalDate date);

    List<EventDTO> searchEvent(String text);
}
