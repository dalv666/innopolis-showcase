package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Award;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.AwardDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.AwardService;

import java.util.List;

@Service
@Transactional
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardDAO awardDAO;

    public Award create(Award object) {
        return awardDAO.save(object);
    }


    public Award delete(Long roomId) {
        Award award = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        awardDAO.delete(award);
        return award;
    }

    public List<Award> findAll() {
        return (List<Award>) awardDAO.findAll();
    }

    public Award findById(Long objectId) {
        return awardDAO.findOne(objectId);
    }

    public Award update(Award object) {
        Award award = awardDAO.findOne(object.getId());
/*        if (award == null) {
            throw new NotFoundException(award.getId(), Room.class);
        }*/
        return awardDAO.save(award);


    }
}
