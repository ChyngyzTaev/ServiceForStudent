package it.academy.demo.service;

import it.academy.demo.entity.Curator;
import it.academy.demo.model.CuratorModel;

public interface TeacherService {
    CuratorModel addNewPost(Curator curator);

    CuratorModel addNewLesson(Curator curator);

    void deletePostById(long id);

    void deleteLessonById(long id);
}
