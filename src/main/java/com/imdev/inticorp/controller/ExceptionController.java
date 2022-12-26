package com.imdev.inticorp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.imdev.inticorp.dto.response.DefaultResponse;
import com.imdev.inticorp.exception.DuplicateDataException;
import com.imdev.inticorp.exception.NotDataFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = { NotDataFoundException.class })
    public ResponseEntity<DefaultResponse<String>> notFoundException(
            RuntimeException ex, WebRequest request) {

        DefaultResponse<String> result = new DefaultResponse<>();
        result.setStatus(HttpStatus.NOT_FOUND.value());
        result.setData(HttpStatus.NOT_FOUND.getReasonPhrase());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @ExceptionHandler(value = { DuplicateDataException.class })
    public ResponseEntity<DefaultResponse<String>> duplicateDataException(
            RuntimeException ex, WebRequest request) {

        DefaultResponse<String> result = new DefaultResponse<>();
        result.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        result.setData("Duplicate data");

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(result);
    }
}
