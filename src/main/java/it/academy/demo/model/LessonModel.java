package it.academy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonModel extends BaseModel{
    private String nameLesson;

    private String room;

    private LocalDateTime localDateTime;
}
