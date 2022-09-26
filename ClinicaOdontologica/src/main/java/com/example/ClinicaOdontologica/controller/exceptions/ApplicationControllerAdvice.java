package com.example.ClinicaOdontologica.controller.exceptions;

import com.example.ClinicaOdontologica.common.exception.FieldsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(FieldsEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraNegocioException(FieldsEmptyException ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErros hadleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getAllErrors().stream()
                .map(e -> e.getDefaultMessage()
                ).collect(Collectors.toList());
        return new ApiErros(erros);
    }
}
