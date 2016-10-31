package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.SpectacleEvent;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.SpectacleEventDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.SpectacleEventService;

import java.util.List;

@Service
@Transactional
public class SpectacleEventServiceImpl implements SpectacleEventService {

    @Autowired
    private SpectacleEventDAO spectacleEventDao;

    public SpectacleEvent create(SpectacleEvent object) {
        return spectacleEventDao.save(object);
    }

    public SpectacleEvent delete(Long objectId) {
        return null;
    }

    public List<SpectacleEvent> findAll() {
        return (List<SpectacleEvent>) spectacleEventDao.findAll();
    }

    public SpectacleEvent findById(Long objectId) {
        return null;
    }

    public SpectacleEvent update(SpectacleEvent object) {
        return null;
    }
}
