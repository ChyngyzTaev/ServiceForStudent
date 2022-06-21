package it.academy.demo.service;

import it.academy.demo.entity.Curator;
import it.academy.demo.model.CuratorModel;

public interface CuratorService {
    CuratorModel addNewPost(Curator curator);

    CuratorModel addNewLesson(Curator curator);

    CuratorModel getPostById(Long id);
}
