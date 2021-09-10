package com.springboot.testingIntellij.dao;

import com.springboot.testingIntellij.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//tells this class has to be instantiated as a beam, so we can inject it in other classes
@Repository("realDao")
public class PersonDataAccess implements PersonDao{
    private static List<Person> DataBase = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DataBase.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DataBase;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DataBase.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if (person.isEmpty()){
            return 0;
        }
        DataBase.remove(person.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        return selectPersonById(id)
                //find id for the object we want to update
                .map(oldPerson -> {
                    //get id f=of the old object
                    int indexPersonToDelete = DataBase.indexOf(oldPerson);
                    //if there is no index it would return -1.
                    if (indexPersonToDelete >= 0){
                        //we change the old object person with a new object person thanks to map
                        DataBase.set(indexPersonToDelete, newPerson);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }
}
