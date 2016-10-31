package ru.innopolis.master.ms1.university.dmd.showcase.service.service.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Khairullin on 18.08.2014.
 * Common service interface with CRUD.
 * Declares methods used to obtain and modify table.
 *
 * @author Khairullin
 */

public interface GenericCRUD<T extends Serializable> {

    /**
     * Creates a new object.
     *
     * @param object The created object.
     * @return The created object.
     */
     T create(T object);

    /**
     * Deletes a object.
     *
     * @param objectId The id of the deleted object.
     * @return The deleted object.
     */
     T delete(Long objectId) ;

    /**
     * Finds all objects.
     *
     * @return A list of objects.
     */
     List<T> findAll();

    /**
     * Finds object by id.
     *
     * @param objectId The id of the wanted object.
     * @return The found object. If no event is found, this method returns null.
     */
     T findById(Long objectId);

    /**
     * Updates the information of a object.
     *
     * @param object The updated object.
     * @return The updated object.
     */
     T update(T object);

}
