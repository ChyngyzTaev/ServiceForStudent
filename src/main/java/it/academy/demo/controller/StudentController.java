package it.academy.demo.controller;

import it.academy.demo.entity.Lesson;
import it.academy.demo.entity.Post;
import it.academy.demo.exception.BadRequestException;
import it.academy.demo.exception.NotFoundException;
import it.academy.demo.model.LessonModel;
import it.academy.demo.model.PostModel;
import it.academy.demo.model.request.AuthenticationRequest;
import it.academy.demo.model.response.AuthenticationResponse;
import it.academy.demo.model.response.ImageModelResponse;
import it.academy.demo.security.jwt.JwtUtil;
import it.academy.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        if (username == null || username.isEmpty())
            return getErrorAuthorizationMessage("Заполните поле логин");

        if (password == null || password.isEmpty())
            return getErrorAuthorizationMessage("Заполните поле пароль");

        if (!username.equals("student") || !password.equals("student"))
            getErrorAuthorizationMessage("Неверный логин или пароль");

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/create/new/post")
    public ResponseEntity addNewPost(@RequestBody PostModel postModel){
        studentService.addNewPost(postModel);
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get-all")
    public List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse){
        return studentService.getAll(imageModelResponse);
    }

    @GetMapping("/get-Lesson/{id}")
    public Lesson getLessonById(Long id){
        return studentService.getLessonById(id);
    }

    @GetMapping("/get-post/{id}")
    public Post getPostById (Long id){
        return studentService.getPostById(id);
    }

    @PutMapping("/update-post")
    public ResponseEntity updatePost(@RequestBody PostModel postModel){
        try {
            return new ResponseEntity(studentService.updatePost(postModel), HttpStatus.OK);
        } catch (BadRequestException bre){
            return new ResponseEntity(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-lesson")
    public ResponseEntity updateLesson(@RequestBody LessonModel lessonModel){
        try {
            return new ResponseEntity(studentService.updateLesson(lessonModel), HttpStatus.OK);
        } catch (BadRequestException bre){
            return new ResponseEntity(bre.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return new ResponseEntity(nfe.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-post/{id}")
    public void deletePostById(Long id){
        studentService.deletePostById(id);
    }

    private ResponseEntity getErrorAuthorizationMessage(String message) {
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }
}
