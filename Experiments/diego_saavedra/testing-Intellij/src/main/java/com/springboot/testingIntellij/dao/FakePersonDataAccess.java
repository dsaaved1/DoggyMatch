package com.springboot.testingIntellij.dao;

import com.springboot.testingIntellij.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//tells this class has to be instantiated as a beam, so we can inject it in other classes
@Repository("fakeDao")
public class FakePersonDataAccess implements PersonDao{
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

}
