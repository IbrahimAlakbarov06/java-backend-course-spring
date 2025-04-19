package turing.edu.az.lesson1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turing.edu.az.lesson1.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {
}
