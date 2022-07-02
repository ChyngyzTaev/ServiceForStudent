package it.academy.demo.service;

import it.academy.demo.entity.Student;
import it.academy.demo.model.StudentModel;

public interface StudentService {
    StudentModel addNewPost(Student student);

    Student searchLessonById(Student student);

    StudentModel searchPostById(Student student);

    StudentModel getLessonById(String name);

    StudentModel getPostById(String name);
}
