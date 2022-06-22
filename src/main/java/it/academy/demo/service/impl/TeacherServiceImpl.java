package it.academy.demo.service.impl;

import it.academy.demo.entity.Curator;
import it.academy.demo.model.CuratorModel;
import it.academy.demo.rapository.TeacherRepository;
import it.academy.demo.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;


    @Override
    public CuratorModel addNewPost(Curator curator) {
        return null;
    }

    @Override
    public CuratorModel addNewLesson(Curator curator) {
        return null;
    }

    @Override
    public void deletePostById(boolean id) {

    }

    @Override
    public void deleteLessonById(boolean id) {

    }
}
