package it.academy.demo.service.impl;

import it.academy.demo.entity.Curator;
import it.academy.demo.entity.Teacher;
import it.academy.demo.model.CuratorModel;
import it.academy.demo.rapository.TeacherRepository;
import it.academy.demo.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Override
    public Teacher addNewPost(Teacher teacher) {
        return null;
    }

    @Override
    public Teacher addNewLesson(Teacher teacher) {
        return null;
    }

    @Override
    public void deletePostById(long id) {

    }

    @Override
    public void deleteLessonById(long id) {

    }
}
