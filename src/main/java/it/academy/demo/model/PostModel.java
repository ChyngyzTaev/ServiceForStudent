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
public class PostModel extends BaseModel {
    private Long id;

    private String post;

    private LocalDateTime localDateTime;
}
