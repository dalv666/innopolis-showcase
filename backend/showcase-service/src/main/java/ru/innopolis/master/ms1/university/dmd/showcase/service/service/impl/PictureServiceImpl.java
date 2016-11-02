package ru.innopolis.master.ms1.university.dmd.showcase.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Picture;
import ru.innopolis.master.ms1.university.dmd.showcase.service.dao.PictureDAO;
import ru.innopolis.master.ms1.university.dmd.showcase.service.service.PictureService;

import java.util.List;
@Service
@Transactional
public class PictureServiceImpl implements PictureService {


    @Autowired
    private PictureDAO pictureDAO;

    public Picture create(Picture object) {
        return pictureDAO.save(object);
    }


    public Picture delete(Long roomId) {
        Picture picture = findById(roomId);
/*        if (room == null) {
            throw new NotFoundException(roomId, Room.class);
        }*/
        pictureDAO.delete(picture);
        return picture;
    }

    public List<Picture> findAll() {
        return (List<Picture>) pictureDAO.findAll();
    }

    public Picture findById(Long objectId) {
        return pictureDAO.findOne(objectId);
    }

    public Picture update(Picture object) {
        Picture picture = pictureDAO.findOne(object.getId());
/*        if (picture == null) {
            throw new NotFoundException(picture.getId(), Room.class);
        }*/
        return pictureDAO.save(picture);


    }
}
