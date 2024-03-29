package it.academy.demo.service;

import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;

import java.util.List;

public interface TeacherService {
    PostModel addNewPost(PostModel post);

    LessonModel addNewLesson(LessonModel lessonModel);


    ImageModelResponse saveImage(ImageModelRequest imageModelRequest);


    List<ImageModelResponse> getAllImage(ImageModelResponse imageModelResponse);

    PostModel getPostById(Long id);

    PostModel updatePost(PostModel postModel);

    LessonModel updateLesson(LessonModel lessonModel);

    void deletePostById(long id);

    void deleteLessonById(long id);
}
