package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.UserDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User create(User object) {
        return userDAO.save(object);
    }


    public User delete(Long roomId) {
        User user = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        userDAO.delete(user);
        return user;
    }

    public List<User> findAll() {
        return (List<User>) userDAO.findAll();
    }

    public User findById(Long objectId) {
        return userDAO.findOne(objectId);
    }

    public User update(User object) {
        User user = userDAO.findOne(object.getId());
/*        if (user == null) {
            throw new NotFoundException(user.getId(), Room.class);
        }*/
        return userDAO.save(user);
    }
}
