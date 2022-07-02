package it.academy.demo.service;

import it.academy.demo.entity.Curator;
import it.academy.demo.entity.Teacher;
import it.academy.demo.model.CuratorModel;

public interface TeacherService {
    Teacher addNewPost(Teacher teacher);

    Teacher addNewLesson(Teacher teacher);

    void deletePostById(long id);

    void deleteLessonById(long id);
}
