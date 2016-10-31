package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Location;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.LocationDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.LocationService;

import java.util.List;
@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDAO locationDAO;

    public Location create(Location object) {
        return locationDAO.save(object);
    }

    public Location delete(Long objectId) {
        return null;
    }

    public List<Location> findAll() {
        return (List<Location>) locationDAO.findAll();
    }

    public Location findById(Long objectId) {
        return null;
    }

    public Location update(Location object) {
        return null;
    }
}
