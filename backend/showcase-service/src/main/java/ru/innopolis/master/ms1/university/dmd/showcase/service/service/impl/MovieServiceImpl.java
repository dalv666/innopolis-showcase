package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Movie;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.MovieDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.MovieService;

import java.util.List;
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    public Movie create(Movie object) {
        return movieDAO.save(object);
    }


    public Movie delete(Long roomId) {
        Movie movie = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        movieDAO.delete(movie);
        return movie;
    }

    public List<Movie> findAll() {
        return (List<Movie>) movieDAO.findAll();
    }

    public Movie findById(Long objectId) {
        return movieDAO.findOne(objectId);
    }

    public Movie update(Movie object) {
        Movie movie = movieDAO.findOne(object.getId());
/*        if (movie == null) {
            throw new NotFoundException(movie.getId(), Room.class);
        }*/
        return movieDAO.save(movie);
    }
}
