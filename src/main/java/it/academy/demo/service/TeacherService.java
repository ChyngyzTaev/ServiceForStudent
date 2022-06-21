package it.academy.demo.service;

import it.academy.demo.model.CuratorModel;

public interface TeacherService {
    CuratorModel addNewPost();

    CuratorModel addNewLesson();

    CuratorModel getPostById();
}
