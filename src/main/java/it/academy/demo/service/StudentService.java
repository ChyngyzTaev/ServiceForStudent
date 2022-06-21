package it.academy.demo.service;

import it.academy.demo.model.StudentModel;

public interface StudentService {
    StudentModel addNewPost();

    StudentModel searchLessonByName();

    StudentModel getNewLesson();

    StudentModel GetPostById();
}
