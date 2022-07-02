package it.academy.demo.service.impl;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.exception.BadRequestException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.rapository.LessonRepository;
import it.academy.demo.rapository.PostRepository;
import it.academy.demo.rapository.StudentRepository;
import it.academy.demo.service.StudentService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private PostRepository postRepository;

    private LessonRepository lessonRepository;
    @Override
    @SneakyThrows
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
    public Optional<Lesson> searchLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    @Override
    public Optional<Post> searchPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public LessonModel getLessonById(Lesson id) {
        return getLessonById(id);
    }

    @Override
    public PostModel getPostById(Lesson id) {
        return getPostById(id);
    }

    private void checkIdForNull(Long id) throws BadRequestException {
        if (id == null) {
            throw new BadRequestException("Идентификатор не может быть пустым! ");
        }
    }
}
