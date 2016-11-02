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


    public Location delete(Long roomId) {
        Location location = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        locationDAO.delete(location);
        return location;
    }

    public List<Location> findAll() {
        return (List<Location>) locationDAO.findAll();
    }

    public Location findById(Long objectId) {
        return locationDAO.findOne(objectId);
    }

    public Location update(Location object) {
        Location location = locationDAO.findOne(object.getId());
/*        if (location == null) {
            throw new NotFoundException(location.getId(), Room.class);
        }*/
        return locationDAO.save(location);
    }
}
