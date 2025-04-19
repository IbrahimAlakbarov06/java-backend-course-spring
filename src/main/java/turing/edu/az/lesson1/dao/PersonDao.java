package turing.edu.az.lesson1.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import turing.edu.az.lesson1.model.Person;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {
}
