package it.academy.demo.service.impl;

import it.academy.demo.entity.Curator;
import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.exception.BadRequestException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.rapository.LessonRepository;
import it.academy.demo.rapository.PostRepository;
import it.academy.demo.service.TeacherService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private PostRepository postRepository;

    private LessonRepository lessonRepository;


    @SneakyThrows
    @Override
    public PostModel addNewPost(Post post, Long id) {
        checkIdForNull(id);
        PostModel postModel = new PostModel();
        post.setId(postModel.getId());
        post.setFirstName(postModel.getFirstName());
        post.setLastName(postModel.getLastName());
        post.setPost(postModel.getPost());
        post.setLocalDateTime(postModel.getLocalDateTime());
        postRepository.save(post);
        return postModel;
    }

    @Override
    @SneakyThrows
    public LessonModel addNewLesson(Lesson lesson, Long id) {
        checkIdForNull(id);
        LessonModel lessonModel = new LessonModel();
        lesson.setId(lessonModel.getId());
        lesson.setFirstName(lessonModel.getFirstName());
        lesson.setLastName(lessonModel.getLastName());
        lesson.setNameLesson(lessonModel.getNameLesson());
        lesson.setLocalDateTime(lessonModel.getLocalDateTime());
        lesson.setRoom(lessonModel.getRoom());
        lessonRepository.save(lesson);
        return lessonModel;
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void deleteLessonById(long id) {
        lessonRepository.deleteById(id);
    }

    private void checkIdForNull(Long id) throws BadRequestException {
        if (id == null) {
            throw new BadRequestException("Идентификатор не может быть пустым! ");
        }
    }
}
