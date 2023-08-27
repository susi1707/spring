package com.rb.Rest_demo.Exception;

import org.springframework.http.HttpStatus;

public class ExceptionDetail {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public ExceptionDetail(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
