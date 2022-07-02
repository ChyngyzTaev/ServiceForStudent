package it.academy.demo.service;

import it.academy.demo.model.request.ImageModelRequest;
import it.academy.demo.model.response.ImageModelResponse;

import java.util.List;

public interface ImageService {
    ImageModelResponse save (ImageModelRequest imageModelRequest);

    List<ImageModelResponse> getAll(ImageModelResponse imageModelResponse);
}
