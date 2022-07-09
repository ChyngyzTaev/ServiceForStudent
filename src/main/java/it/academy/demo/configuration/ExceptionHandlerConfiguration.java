package it.academy.demo.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerConfiguration{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handler(Exception ex, WebRequest request){
        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
