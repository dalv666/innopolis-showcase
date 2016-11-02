package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Person;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.PersonDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.PersonService;

import java.util.List;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonDAO personDAO;

    public Person create(Person object) {
        return personDAO.save(object);
    }


    public Person delete(Long roomId) {
        Person person = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        personDAO.delete(person);
        return person;
    }

    public List<Person> findAll() {
        return (List<Person>) personDAO.findAll();
    }

    public Person findById(Long objectId) {
        return personDAO.findOne(objectId);
    }

    public Person update(Person object) {
        Person person = personDAO.findOne(object.getId());
/*        if (person == null) {
            throw new NotFoundException(person.getId(), Room.class);
        }*/
        return personDAO.save(person);


    }
}
