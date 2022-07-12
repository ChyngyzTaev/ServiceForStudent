package it.academy.demo.service;

import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;

public interface TeacherService {
    PostModel addNewPost(PostModel post);

    LessonModel addNewLesson(LessonModel lessonModel);

    PostModel getPostById(Long id);

    PostModel updatePost(PostModel postModel);

    LessonModel updateLesson(LessonModel lessonModel);

    void deletePostById(long id);

    void deleteLessonById(long id);
}
