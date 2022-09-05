package com.example.ClinicaOdontologica.controller.exception;

import com.example.ClinicaOdontologica.service.exceptions.ObjectNotFoundException;
import com.example.ClinicaOdontologica.service.exceptions.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(
            ObjectNotFoundException exception, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(
                Instant.now(), status.value(), "Object not Found",
                exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> sqlIntegrityConstraintViolation(
            ConstraintViolationException exception, HttpServletRequest request) {

        String errorMessage = "Error por violações de restrição";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), errorMessage,
                exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
