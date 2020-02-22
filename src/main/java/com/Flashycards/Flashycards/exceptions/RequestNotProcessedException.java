package com.Flashycards.Flashycards.exceptions;

import org.springframework.http.HttpStatus;

public class RequestNotProcessedException extends  RuntimeException {

    private final String message;

    private final HttpStatus httpStatus;


    public RequestNotProcessedException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
