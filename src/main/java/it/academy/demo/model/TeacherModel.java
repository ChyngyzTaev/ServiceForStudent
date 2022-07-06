package it.academy.demo.model;

import it.academy.demo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherModel {
    private Long id;

    private Teacher fullName;

    private String nameLesson;

    private String numberRoom;

    private String post;
}
