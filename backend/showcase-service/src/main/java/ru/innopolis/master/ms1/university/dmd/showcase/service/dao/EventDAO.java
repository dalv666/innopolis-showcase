package ru.innopolis.master.ms1.university.dmd.showcase.service.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.Event;
import ru.innopolis.master.ms1.university.dmd.showcase.common.model.User;

@Repository
public interface EventDAO extends CrudRepository<Event, Long> {


    @Query("SELECT u FROM Event AS e LEFT JOIN e.users AS u where e = :event and u is not null")
    Page<User> getEventUsers(@Param("event") Event event, Pageable pageable);


}
