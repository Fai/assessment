package com.kbtg.bootcamp.posttest.exception;

public class ApiExceptionResponse {
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

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
