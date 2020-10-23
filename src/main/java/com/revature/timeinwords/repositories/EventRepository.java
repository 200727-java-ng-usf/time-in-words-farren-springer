package com.revature.lastdayproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends CrudRepository<com.revature.lastdayproject.entities.Event, Integer> {

    /**
     * findAppUserById method: The id parameter is passed as the input.
     * A user is returned when the input id matches a database record.
     * @param id user id int
     * @return user with matching id int
     */
    com.revature.lastdayproject.entities.Event findAppUserById(int id);

}
