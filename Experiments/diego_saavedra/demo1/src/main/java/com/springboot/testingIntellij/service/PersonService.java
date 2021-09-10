package com.springboot.testingIntellij.service;

import com.springboot.testingIntellij.dao.PersonDao;
import com.springboot.testingIntellij.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//you can get you jar you can deploy to a server and have your app up and running.
//It is located on target folder once you get installed Maven into your app.

@Service
public class PersonService {
    private final PersonDao personDao;

    //we are injecting into the actual constructor the database "realDao".
    //we could switch our database "emptyDao" just by changing the name below.
    @Autowired
    public PersonService(@Qualifier("realDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){return personDao.deletePersonById(id);}

    public int updatePerson(UUID id, Person newPerson){return personDao.updatePersonById(id, newPerson);}

}
