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


    public SpectacleEvent delete(Long roomId) {
        SpectacleEvent event = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        spectacleEventDao.delete(event);
        return event;
    }

    public List<SpectacleEvent> findAll() {
        return (List<SpectacleEvent>) spectacleEventDao.findAll();
    }

    public SpectacleEvent findById(Long objectId) {
        return spectacleEventDao.findOne(objectId);
    }

    public SpectacleEvent update(SpectacleEvent object) {
        SpectacleEvent event = spectacleEventDao.findOne(object.getId());
/*        if (event == null) {
            throw new NotFoundException(event.getId(), Room.class);
        }*/
        return spectacleEventDao.save(event);
    }
}
