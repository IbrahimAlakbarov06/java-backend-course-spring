package turing.edu.az.lesson1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import turing.edu.az.lesson1.model.Person;
import turing.edu.az.lesson1.service.PersonService;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final PersonService personService;

    @GetMapping("/persons")
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "persons/list";
    }

    @GetMapping("/persons/create")
    public String createPersonForm() {
        return "persons/create";
    }

    @PostMapping("/persons")
    public String createPerson(@RequestParam("name") String name) {
        Person newPerson = new Person();
        newPerson.setName(name);
        personService.createPerson(newPerson);
        return "redirect:/persons";
    }

    @GetMapping("/persons/update/{id}")
    public String updatePersonForm(@PathVariable("id") long id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "persons/update";
    }

    @PutMapping("/persons/{id}")
    public String updatePerson(@PathVariable("id") long id, @RequestParam("name") String name) {
        Person person = personService.getPersonById(id);
        person.setName(name);
        personService.updatePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}