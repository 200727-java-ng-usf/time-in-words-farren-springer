package com.revature.lastdayproject.services;

import com.revature.lastdayproject.exceptions.InvalidRequestException;
import com.revature.lastdayproject.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private com.revature.lastdayproject.repositories.EventRepository userRepository;

    @Autowired
    public AppUserService(com.revature.lastdayproject.repositories.EventRepository repo) { this.userRepository = repo; }

    /**
     * getall method: Returns a list of all the appUser objects in the database.
     * @return a list of all the appUsers
     * @throws ResourceNotFoundException when no appUsers are found
     */
    @Transactional(readOnly = true)
    public List<com.revature.lastdayproject.dtos.EventDto> getAllUsers(){

        Iterable<com.revature.lastdayproject.entities.Event> iterable = userRepository.findAll();
        List<com.revature.lastdayproject.entities.Event> users = getListFromIterator(iterable);
        if(users.isEmpty()){
            throw new ResourceNotFoundException();
        }
        List<com.revature.lastdayproject.dtos.EventDto> userDtos = new ArrayList<>();
        for(com.revature.lastdayproject.entities.Event user : users){
            userDtos.add(new com.revature.lastdayproject.dtos.EventDto(user));
        }
        return userDtos;

    }

    /**
     * getUserById method: Returns an appUser object when the id int matches a record in the database.
     * @param id appUserId int value
     * @return an appUser with matching id
     * @throws ResourceNotFoundException when an appUser is not found
     */
    @Transactional(readOnly = true)
    public com.revature.lastdayproject.dtos.EventDto getUserById(int id){

        if(id <= 0){
            throw new InvalidRequestException("Id number must be 1 or greater");
        }
        com.revature.lastdayproject.entities.Event retrievedUser = userRepository.findAppUserById(id);
        if(retrievedUser == null){
            throw new ResourceNotFoundException("No user with id: " + id + " was found");
        }
        return new com.revature.lastdayproject.dtos.EventDto(retrievedUser);

    }




    /**
     * getListFromIterator method: Changes an iterator to a list object
     * @param iterable Iterable retrieved from repository
     * @return List of stated type
     */

    public static <T> List<T> getListFromIterator(Iterable<T> iterable) {

        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;

    }


}
