package it.academy.demo.controller;

import it.academy.demo.exception.BadRequestException;
import it.academy.demo.model.PostModel;
import it.academy.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/crete/new/post")
    public ResponseEntity addNewPost(@RequestBody PostModel postModel){
        studentService.addNewPost(postModel);
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
