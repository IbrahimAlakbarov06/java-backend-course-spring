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
        return personDao.findAll();
    }

    public void createPerson(Person student) {
        personDao.save(student);
    }

    public String deletePerson(long id) {
         personDao.deleteById(id);
         return "Person deleted";
    }

//    public String updatePerson(Person student) {
//        personDao.saveAll(student);
//        if (rowsAffected > 0) {
//            return "Person updated successfully!";
//        } else {
//            throw new PersonNotFoundException("Person with id " + student.getId() + " not found.");
//        }
//    }

    public Person getPersonById(long id) {
        return personDao.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with id " + id + " not found."));
    }
}
