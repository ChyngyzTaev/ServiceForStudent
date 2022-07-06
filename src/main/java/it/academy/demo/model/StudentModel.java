package it.academy.demo.model;

import it.academy.demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel{
    private Long id;

    private Student fullName;

    private Long course;

    private String courseName;

    private String post;
}
