package turing.edu.az.lesson1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private long id;

    @NonNull

    private String name;
}
