package it.academy.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Curator extends BaseEntity{

    @Column(name = "lesson_name", unique = true)
    private String lessonName;

    @Column(name = "course_student")
    private int courseStudent;
}
