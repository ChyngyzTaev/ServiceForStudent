package it.academy.demo.service;

import it.academy.demo.entity.Student;
import it.academy.demo.model.StudentModel;

public interface StudentService {
    StudentModel addNewPost(Student student);

    StudentModel searchLessonByName(Student student);

    StudentModel searchPostByName(Student student);

    StudentModel getLessonByName(Student student);

     StudentModel getPostByName(Student student);
}
