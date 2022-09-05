package com.example.ClinicaOdontologica.service.exceptions;

public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String msg) {
        super(msg);
    }
}
