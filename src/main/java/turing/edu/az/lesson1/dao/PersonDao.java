package turing.edu.az.lesson1.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import turing.edu.az.lesson1.model.Person;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonDao {

     private final JdbcTemplate jdbcTemplate;


    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Person(rs.getLong("id"), rs.getString("name"))
        );
    }

    public int addPerson(Person student) {
        String sql = "INSERT INTO students (name) VALUES (?)";
        return jdbcTemplate.update(sql, student.getName());
    }

    public int deletePerson(long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updatePerson(Person student) {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getId());
    }

    public Person getPersonById(long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new Person(rs.getLong("id"), rs.getString("name")), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
