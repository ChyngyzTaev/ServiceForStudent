package it.academy.demo.controller;

import it.academy.demo.exception.BadRequestException;
import it.academy.demo.exception.NotFoundException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create/new/post")
    public ResponseEntity addNewPost(@RequestBody PostModel postModel) {
        try {
            return new ResponseEntity(teacherService.addNewPost(postModel), HttpStatus.OK);
        } catch (BadRequestException badRequestException) {
            return new ResponseEntity(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create/new/lesson")
    public ResponseEntity addNewLesson(@RequestBody LessonModel lessonModel) {
        try {
            return new ResponseEntity(teacherService.addNewLesson(lessonModel), HttpStatus.OK);
        } catch (BadRequestException badRequestException) {
            return new ResponseEntity(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-post/{id}")
    public ResponseEntity getPostById(@PathVariable Long id) {
        try {
            return new ResponseEntity(teacherService.getPostById(id), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-post")
    public ResponseEntity updatePost(@RequestBody PostModel postModel) {
        try {
            return new ResponseEntity(teacherService.updatePost(postModel), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-lesson")
    public ResponseEntity updateLesson(@RequestBody LessonModel lessonModel) {
        try {
            return new ResponseEntity(teacherService.updateLesson(lessonModel), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-post/{id}")
    public void deletePostById(Long id) {
        teacherService.deletePostById(id);
    }

    @DeleteMapping("/delete-lesson/{id}")
    public void deleteLessonById(Long id) {
        teacherService.deleteLessonById(id);
    }

    private ResponseEntity getErrorAuthorizationMessage(String message) {
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }
}
