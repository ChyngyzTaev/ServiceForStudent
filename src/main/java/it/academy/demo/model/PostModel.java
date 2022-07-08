package it.academy.demo.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    private Long id;

    private String fullName;

    private String post;

    private LocalDateTime createdAt;
}
