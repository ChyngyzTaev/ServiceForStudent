package it.academy.demo.service.impl;

import it.academy.demo.entity.Image;
import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;
import it.academy.demo.rapository.ImageRepository;
import it.academy.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    final ImageRepository imageRepository;
    final String urlPath = "C:\\Users\\user\\Desktop";

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageModelResponse save(ImageModelRequest imageModelRequest) {
        Image image = null;

        try {
            File imageFile = new File(urlPath + imageModelRequest.getName() + ".png");
            imageModelRequest.getFile().transferTo(imageFile);

            image = imageRepository.save(Image.builder()
                            .nameFile(imageFile.getName())
                            .pathFile(imageFile.getName())
                    .build());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ImageModelResponse.builder()
                .name(image.getNameFile())
                .path(image.getPathFile())
                .build();
    }

    @Override
    public List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse) {
        List<ImageModelResponse> imageModelResponses = new ArrayList<>();

        imageRepository.findAll().forEach(x -> imageModelResponses.add(
                ImageModelResponse.builder()
                        .name(x.getNameFile())
                        .path(x.getPathFile())
                        .build()
        ));
        return imageModelResponses;
    }
}
