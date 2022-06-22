package it.academy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuratorModel extends BaseModel{
    private String nameLesson;

    private String numberRoom;

    private String post;

    private String lesson;
}
