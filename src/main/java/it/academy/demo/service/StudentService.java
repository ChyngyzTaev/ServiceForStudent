package it.academy.demo.service;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;

import java.util.Optional;

public interface StudentService {
    PostModel addNewPost(Post post, Long id);

    Optional<Lesson> searchLessonById(Long id);

    Optional<Post> searchPostById(Long id);

    Lesson getLessonById(Long id);

    Post getPostById(Long id);
}
