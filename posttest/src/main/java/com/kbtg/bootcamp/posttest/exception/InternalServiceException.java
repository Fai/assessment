package com.kbtg.bootcamp.posttest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServiceException extends RuntimeException {
    public InternalServiceException(String message) {
        super(message);
    }
}
