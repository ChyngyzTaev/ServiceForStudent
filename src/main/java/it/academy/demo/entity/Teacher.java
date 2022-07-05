package it.academy.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_Name")
    private String fullName;

    @Column(name = "lesson_name", unique = true)
    private String lessonName;

    @OneToMany
    @JoinColumn(name = "group_id")
    List<Group> groups;

    @OneToMany
    @JoinColumn(name = "lesson_id")
    List<Lesson> lessons;
}
