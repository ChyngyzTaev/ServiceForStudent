package it.academy.demo.service.impl;

import it.academy.demo.entity.Curator;
import it.academy.demo.exception.BadRequestException;
import it.academy.demo.exception.NotFoundException;
import it.academy.demo.model.CuratorModel;
import it.academy.demo.rapository.CuratorRepository;
import it.academy.demo.service.CuratorService;
import org.springframework.stereotype.Service;

@Service
public class CuratorServiceImpl implements CuratorService {

    private CuratorRepository curatorRepository;

    @Override
    public CuratorModel addNewPost(Curator curator) {
        return null;
    }

    @Override
    public CuratorModel addNewLesson(Curator curator) {
        return null;
    }

    @Override
    public CuratorModel getPostById(Long id) {
        return null;
    }

    private void checkIdForNull(Long id) throws BadRequestException {
        if (id == null) {
            throw new BadRequestException("Идентификатор не может быть пустым! ");
        }
    }
}
