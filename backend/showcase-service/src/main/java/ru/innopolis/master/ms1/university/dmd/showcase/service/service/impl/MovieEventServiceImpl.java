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

    public MovieEvent delete(Long objectId) {
        return null;
    }

    public List<MovieEvent> findAll() {
        return (List<MovieEvent>) movieEventDAO.findAll();
    }

    public MovieEvent findById(Long objectId) {
        return null;
    }

    public MovieEvent update(MovieEvent object) {
        return null;
    }
}
