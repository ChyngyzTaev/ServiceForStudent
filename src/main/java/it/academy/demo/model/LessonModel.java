package it.academy.demo.model;

import it.academy.demo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonModel {
    private Long id;

    private Teacher fullName;

    private String nameLesson;

    private String room;

    private LocalDateTime createdAt;
}
