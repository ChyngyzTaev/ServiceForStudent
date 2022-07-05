package it.academy.demo.service.impl;

import it.academy.demo.entity.Image;
import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.exception.BadRequestException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;
import it.academy.demo.rapository.ImageRepository;
import it.academy.demo.rapository.LessonRepository;
import it.academy.demo.rapository.PostRepository;
import it.academy.demo.service.TeacherService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private PostRepository postRepository;
    private LessonRepository lessonRepository;
    private ImageRepository imageRepository;



    final String urlPath = "C:\\Users\\user\\Desktop";

    @Autowired
    public TeacherServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageModelResponse saveImage(ImageModelRequest imageModelRequest) {
        Image image = null;

        try {
            File imageFile = new File(urlPath + imageModelRequest.getName() + ".png");
            imageModelRequest.getFile().transferTo(imageFile);

            image = imageRepository.save(Image.builder()
                    .nameFile(imageFile.getName())
                    .pathFile(imageFile.getName())
                    .build());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ImageModelResponse.builder()
                .name(image.getNameFile())
                .path(image.getPathFile())
                .build();
    }

    @Override
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


    @SneakyThrows
    @Override
    public PostModel addNewPost(Post post, Long id) {
        checkIdForNull(id);
        PostModel postModel = new PostModel();
        post.setId(postModel.getId());
        post.setFullName(postModel.getFullName());
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
        lesson.setFullName(lessonModel.getFullName());
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
