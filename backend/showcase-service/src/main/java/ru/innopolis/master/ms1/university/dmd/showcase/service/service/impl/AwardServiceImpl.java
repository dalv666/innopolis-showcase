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

    public Award delete(Long objectId) {
        return null;
    }

    public List<Award> findAll() {
        return (List<Award>) awardDAO.findAll();
    }

    public Award findById(Long objectId) {
        return null;
    }

    public Award update(Award object) {
        return null;
    }
}
