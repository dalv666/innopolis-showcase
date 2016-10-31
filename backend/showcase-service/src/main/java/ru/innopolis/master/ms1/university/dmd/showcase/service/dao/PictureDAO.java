package ru.innopolis.master.ms1.university.dmd.showcase.service.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Picture;

@Repository
public interface PictureDAO extends CrudRepository<Picture, Long> {

}
