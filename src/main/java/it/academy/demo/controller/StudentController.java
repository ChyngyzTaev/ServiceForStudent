package it.academy.demo.controller;

import it.academy.demo.exception.BadRequestException;
import it.academy.demo.exception.NotFoundException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;
import it.academy.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create/new/post")
    public ResponseEntity<?> addNewPost(@RequestBody PostModel postModel) {
        try {
            return new ResponseEntity<>(studentService.addNewPost(postModel), HttpStatus.OK);
        } catch (BadRequestException badRequestException) {
            return new ResponseEntity<>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/save-image")
    public ResponseEntity<?> saveImage(ImageModelRequest imageModelRequest){
        try {
            return new ResponseEntity<>(studentService.saveImage(imageModelRequest), HttpStatus.OK);
        }catch (BadRequestException badRequestException){
            return new ResponseEntity<>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (NotFoundException notFoundException){
            return new ResponseEntity<>(notFoundException.getMessage(),HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get-all-image")
    public ResponseEntity<?> getAllImage(ImageModelResponse imageModelResponse) {
        try {
            return new ResponseEntity<>(studentService.getAllImage(imageModelResponse), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity<>(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-lesson/{id}")
    public ResponseEntity<?> getLessonById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(studentService.getLessonById(id), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity<>(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-post/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(studentService.getPostById(id), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity<>(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-post")
    public ResponseEntity<?> updatePost(@RequestBody PostModel postModel) {
        try {
            return new ResponseEntity<>(studentService.updatePost(postModel), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity<>(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-lesson")
    public ResponseEntity<?> updateLesson(@RequestBody LessonModel lessonModel) {
        try {
            return new ResponseEntity<>(studentService.updateLesson(lessonModel), HttpStatus.OK);
        } catch (BadRequestException bre) {
            return new ResponseEntity<>(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable  Long id) {
        studentService.deletePostById(id);
        return ResponseEntity.ok(true);
    }
}
