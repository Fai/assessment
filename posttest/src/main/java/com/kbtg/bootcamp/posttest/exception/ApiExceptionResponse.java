package com.kbtg.bootcamp.posttest.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptionResponse {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

    public ApiExceptionResponse(String message, HttpStatus httpStatus, ZonedDateTime now) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = now;
    }

    public String getMessage() {
        return message;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
