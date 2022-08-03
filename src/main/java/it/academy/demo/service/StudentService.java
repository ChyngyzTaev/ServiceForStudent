package it.academy.demo.service;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;

import java.util.List;

public interface StudentService {
    PostModel addNewPost(PostModel postModel);

    ImageModelResponse saveImage(ImageModelRequest imageModelRequest);


    List<ImageModelResponse> getAllImage(ImageModelResponse imageModelResponse);

    Lesson getLessonById(Long id);

    Post getPostById(Long id);

    PostModel updatePost(PostModel postModel);

    LessonModel updateLesson(LessonModel lessonModel);

    void deletePostById(long id);
}
