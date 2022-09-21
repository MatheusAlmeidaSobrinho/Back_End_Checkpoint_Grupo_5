package com.example.ClinicaOdontologica.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseException {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private List<String> listVariable;

    public ResponseException() {
    }

    public ResponseException(int status, String message, LocalDateTime timestamp, List<String> listVariable) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.listVariable = listVariable;
    }

    public ResponseException(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<String> getListVariable() {
        return listVariable;
    }
}