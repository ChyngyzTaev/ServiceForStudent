package it.academy.demo.service;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;

import java.util.List;

public interface TeacherService {
    PostModel addNewPost(Post post, Long id);

    LessonModel addNewLesson(Lesson lesson, Long id);

    ImageModelResponse saveImage (ImageModelRequest imageModelRequest);

    List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse);

    Post getPostById(Long id);

    void deletePostById(long id);

    void deleteLessonById(long id);
}
