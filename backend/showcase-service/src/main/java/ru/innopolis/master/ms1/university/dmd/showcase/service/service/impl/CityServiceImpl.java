package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.City;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.CityDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.CityService;

import java.util.List;
@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    public City create(City object) {
        return cityDAO.save(object);
    }

    public City delete(Long objectId) {
        return null;
    }

    public List<City> findAll() {
        return (List<City>) cityDAO.findAll();
    }

    public City findById(Long objectId) {
        return null;
    }

    public City update(City object) {
        return null;
    }
}
