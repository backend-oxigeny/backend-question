package com.oxigenybackend.question.controllers.excptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> NotFoundError(EntityNotFoundException e, HttpRequest request){
        return ResponseEntity.notFound().build(new Error(e.getMessage()),request.getURI().getPath());
    }
}
