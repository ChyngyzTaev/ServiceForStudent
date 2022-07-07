package it.academy.demo.service.impl;

import com.sun.istack.NotNull;
import it.academy.demo.entity.Image;
import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.exception.BadRequestException;
import it.academy.demo.exception.NotFoundException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;
import it.academy.demo.rapository.*;
import it.academy.demo.service.TeacherService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private UpdateLessonRepository updateLessonRepository;
    private UpdatePostRepository updatePostRepository;
    private PostRepository postRepository;
    private LessonRepository lessonRepository;
    private ImageRepository imageRepository;


    private final static String URL_PATH = "C:\\Users\\user\\Desktop";

    @Autowired
    public TeacherServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @SneakyThrows
    @Override
    public PostModel addNewPost(PostModel postModel) {
        Post post = new Post();
        post.setId(postModel.getId());
        post.setFullName(postModel.getFullName());
        post.setPost(postModel.getPost());
        post.setCreatedAt(postModel.getCreatedAt());
        postRepository.save(post);
        return postModel;
    }

    @Override
    @SneakyThrows
    @NotNull
    public LessonModel addNewLesson(LessonModel lessonModel) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonModel.getId());
        lesson.setCreatedBy(lessonModel.getFullName());
        lesson.setNameLesson(lessonModel.getNameLesson());
        lesson.setCreatedAt(lessonModel.getCreatedAt());
        lesson.setRoom(lessonModel.getRoom());
        lessonRepository.save(lesson);
        return lessonModel;
    }

    public ImageModelResponse saveImage(ImageModelRequest imageModelRequest) {
        Image image = null;

        try {
            File imageFile = new File(URL_PATH + imageModelRequest.getName() + ".png");
            imageModelRequest.getFile().transferTo(imageFile);

            image = imageRepository.save(Image.builder()
                    .nameFile(imageFile.getName())
                    .pathFile(imageFile.getName())
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ImageModelResponse.builder()
                .name(image.getNameFile())
                .path(image.getPathFile())
                .build();
    }

    public List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse) {
        List<ImageModelResponse> imageModelResponses = new ArrayList<>();

        imageRepository.findAll().forEach(x -> imageModelResponses.add(
                ImageModelResponse.builder()
                        .name(x.getNameFile())
                        .path(x.getPathFile())
                        .build()
        ));
        return imageModelResponses;
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id: " + id + "не найден"));
    }

    @Override
    public PostModel updatePost(PostModel postModel){
        Long id = postModel.getId();
        checkIdForNull(id);
        Post post = updatePostRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Идентификатор поста: " + id + "не найден"));
        updatePostRepository.save(post);
        return postModel;
    }

    @Override
    public LessonModel updateLesson(LessonModel lessonModel){
        Long id = lessonModel.getId();
        checkIdForNull(id);
        Lesson lesson = updateLessonRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Идентификатор урока: " + id + "не найден"));
        updateLessonRepository.save(lesson);
        return lessonModel;
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void deleteLessonById(long id) {
        lessonRepository.deleteById(id);
    }

    private void checkIdForNull(Long id) {
        if (id == null) {
            throw new BadRequestException("Идентификатор не может быть пустым! ");
        }
    }
}
