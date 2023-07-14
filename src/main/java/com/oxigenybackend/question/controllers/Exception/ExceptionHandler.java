package com.oxigenybackend.question.controllers.Exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException e, WebRequest request){
        String error = "Usuário não encontrado.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> internalError(SQLIntegrityConstraintViolationException e, WebRequest request){
        String error = "Usuário não pode ser excluído.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
