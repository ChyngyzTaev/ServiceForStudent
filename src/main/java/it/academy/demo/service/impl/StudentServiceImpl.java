package it.academy.demo.service.impl;

import it.academy.demo.entity.Student;
import it.academy.demo.model.StudentModel;
import it.academy.demo.rapository.StudentRepository;
import it.academy.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    @Override
    public StudentModel addNewPost(Student student) {
        return null;
    }

    @Override
    public Student searchLessonByName(Student student) {
         return null;
    }

    @Override
    public StudentModel searchPostByName(Student student) {
        return null;
    }

    @Override
    public StudentModel getLessonById(String name) {
        return studentRepository.getLessonByName(name);
    }

    @Override
    public StudentModel getPostById(String name) {
        return studentRepository.getLessonByName(name);
    }
}
