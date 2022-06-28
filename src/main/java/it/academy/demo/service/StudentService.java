package it.academy.demo.service;

import it.academy.demo.entity.Student;
import it.academy.demo.model.StudentModel;

public interface StudentService {
    StudentModel addNewPost(Student student);

    Student searchLessonByName(Student student);

    StudentModel searchPostByName(Student student);

    StudentModel getLessonById(String name);

    StudentModel getPostById(String name);
}
