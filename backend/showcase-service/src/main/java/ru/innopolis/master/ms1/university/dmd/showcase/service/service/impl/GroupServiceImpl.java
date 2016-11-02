package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Group;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.GroupDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.GroupService;

import java.util.List;
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDAO groupDAO;

    public Group create(Group object) {
        return groupDAO.save(object);
    }


    public Group delete(Long roomId) {
        Group group = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        groupDAO.delete(group);
        return group;
    }

    public List<Group> findAll() {
        return (List<Group>) groupDAO.findAll();
    }

    public Group findById(Long objectId) {
        return groupDAO.findOne(objectId);
    }

    public Group update(Group object) {
        Group group = groupDAO.findOne(object.getId());
/*        if (group == null) {
            throw new NotFoundException(group.getId(), Room.class);
        }*/
        return groupDAO.save(group);
    }
}
