package it.academy.demo.service;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;

public interface TeacherService {
    PostModel addNewPost(Post post, Long id);

    LessonModel addNewLesson(Lesson lesson, Long id);

    void deletePostById(long id);

    void deleteLessonById(long id);
}
