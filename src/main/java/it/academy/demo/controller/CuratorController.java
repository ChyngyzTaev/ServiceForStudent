package it.academy.demo.controller;

import it.academy.demo.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuratorController {
    @Autowired
    private CuratorService curatorService;

}
