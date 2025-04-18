package turing.edu.az.lesson1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import turing.edu.az.lesson1.dao.PersonDao;
import turing.edu.az.lesson1.exception.PersonNotFoundException;
import turing.edu.az.lesson1.model.Person;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;

    public List<Person> getAllPersons() {
        return personDao.getAllPersons();
    }

    public String createPerson(Person student) {
        int rowsAffected = personDao.addPerson(student);
        if (rowsAffected > 0) {
            return "Person created successfully!";
        } else {
            throw new RuntimeException("Failed to create student.");
        }
    }

    public String deletePerson(long id) {
        int rowsAffected = personDao.deletePerson(id);
        if (rowsAffected > 0) {
            return "Person deleted successfully!";
        } else {
            throw new PersonNotFoundException("Person with id " + id + " not found.");
        }
    }

    public String updatePerson(Person student) {
        int rowsAffected = personDao.updatePerson(student);
        if (rowsAffected > 0) {
            return "Person updated successfully!";
        } else {
            throw new PersonNotFoundException("Person with id " + student.getId() + " not found.");
        }
    }

    public Person getPersonById(long id) {
        Person student = personDao.getPersonById(id);
        if (student == null) {
            throw new PersonNotFoundException("Person with id " + id + " not found.");
        }
        return student;
    }
}
