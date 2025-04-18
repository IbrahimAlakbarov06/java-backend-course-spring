package turing.edu.az.lesson1.controller;

import org.springframework.web.bind.annotation.*;
import turing.edu.az.lesson1.model.Person;
import turing.edu.az.lesson1.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("api/v2/person")
public class PersonController {

    PersonService personService;

    @GetMapping
    public List<Person> getPersons(){
        return personService.getAllPersons();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody Person person){
        personService.updatePerson(person);
    }

    @GetMapping ("/{id}")
    public Person getPerson(@PathVariable int id){
        return personService.getPersonById(id);
    }
}
