package it.academy.demo.service;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    PostModel addNewPost(Post post, Long id);

    ImageModelResponse saveImage (ImageModelRequest imageModelRequest);

    List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse);

    Optional<Lesson> searchLessonById(Long id);

    Optional<Post> searchPostById(Long id);

    Lesson getLessonById(Long id);

    Post getPostById(Long id);
}
