package it.academy.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends BaseEntity{

    @Column(name = "course")
    private int course;

    @Column(name = "course_name")
    private String courseName;
}
