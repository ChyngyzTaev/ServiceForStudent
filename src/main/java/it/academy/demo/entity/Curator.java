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

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "course_student")
    private String courseStudent;

    @Column(name = "post")
    private String post;

    @Column(name = "lesson")
    private String lesson;
}
