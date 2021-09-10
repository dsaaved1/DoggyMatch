package com.springboot.testingIntellij.api;

import com.springboot.testingIntellij.model.Person;
import com.springboot.testingIntellij.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

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
    public void addPerson(@RequestBody @NonNull Person person) {
        personService.addPerson(person);
    }

    //will be served as GET request
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{idd}")
    public Person getPersonById(@PathVariable("idd") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    //you could put annotation @Valid in Person parameter
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody @NonNull Person newPerson){
        return personService.updatePerson(id, newPerson);
    }

}
