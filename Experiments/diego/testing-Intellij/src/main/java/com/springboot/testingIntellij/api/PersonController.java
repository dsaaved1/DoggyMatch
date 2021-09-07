package com.springboot.testingIntellij.api;

import com.springboot.testingIntellij.model.Person;
import com.springboot.testingIntellij.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//We use annotations to drive our implementation

//We will get the requests of the user in this class (GET, POST, HTTP, etc)
//GET is to retrieve data from your server
//POST is to add a resource to your server
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    //springboard injects the actual service into this constructor
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //will be served as POST request
    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    //will be served as GET request
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
}
