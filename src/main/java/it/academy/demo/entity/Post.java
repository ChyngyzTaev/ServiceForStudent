package it.academy.demo.entity;

import it.academy.demo.model.PostModel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_Name")
    private String fullName;

    @Column(name = "post")
    private String post;

    @Column(name = "local_date_time")
    private LocalDateTime createdAt;

    public PostModel toModel(){
        return PostModel.builder()
                .id(id)
                .fullName(fullName)
                .post(post)
                .build();
    }
}
