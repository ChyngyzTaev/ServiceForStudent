package it.academy.demo.service.impl;

import it.academy.demo.model.StudentModel;
import it.academy.demo.rapository.StudentRepository;
import it.academy.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentModel addNewPost() {
        return null;
    }

    @Override
    public StudentModel searchLessonByName() {
        return null;
    }

    @Override
    public StudentModel getNewLesson() {
        return null;
    }

    @Override
    public StudentModel GetPostById() {
        return null;
    }
}
