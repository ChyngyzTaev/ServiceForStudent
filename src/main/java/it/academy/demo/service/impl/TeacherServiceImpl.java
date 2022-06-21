package it.academy.demo.service.impl;

import it.academy.demo.model.CuratorModel;
import it.academy.demo.rapository.TeacherRepository;
import it.academy.demo.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Override
    public CuratorModel addNewPost() {
        return null;
    }

    @Override
    public CuratorModel addNewLesson() {
        return null;
    }

    @Override
    public CuratorModel getPostById() {
        return null;
    }
}
