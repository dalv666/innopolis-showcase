package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.MovieEvent;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.MovieEventDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.MovieEventService;

import java.util.List;

@Service
@Transactional
public class MovieEventServiceImpl implements MovieEventService {

    @Autowired
    private MovieEventDAO movieEventDAO;

    public MovieEvent create(MovieEvent object) {
        return movieEventDAO.save(object);
    }


    public MovieEvent delete(Long roomId) {
        MovieEvent movieEvent = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        movieEventDAO.delete(movieEvent);
        return movieEvent;
    }

    public List<MovieEvent> findAll() {
        return (List<MovieEvent>) movieEventDAO.findAll();
    }

    public MovieEvent findById(Long objectId) {
        return movieEventDAO.findOne(objectId);
    }

    public MovieEvent update(MovieEvent object) {
        MovieEvent movieEvent = movieEventDAO.findOne(object.getId());
/*        if (movieEvent == null) {
            throw new NotFoundException(movieEvent.getId(), Room.class);
        }*/
        return movieEventDAO.save(movieEvent);
    }
}
