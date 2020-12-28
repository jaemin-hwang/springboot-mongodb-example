package com.jaemin.data.api.common.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class JaeminException extends RuntimeException {

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    private ErrorMessageCode errorMessagerCode = ErrorMessageCode.ERROR;
    private List<JaeminError> errors;


    public JaeminException(String message) {
        super(message);
    }

    public JaeminException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public JaeminException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorMessagerCode = errorMessagerCode;
    }

    public JaeminException(String message, ErrorMessageCode errorMessagerCode) {
        super(message);
        this.errorMessagerCode = errorMessagerCode;
    }

    public JaeminException(ErrorMessageCode errorMessagerCode) {
        this.errorMessagerCode = errorMessagerCode;
    }


    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public ErrorMessageCode getErrorMessagerCode() {
        return this.errorMessagerCode;
    }

    public List<JaeminError> getErrors() {
        return this.errors;
    }

    public void setErrors(List<JaeminError> errors) {
        this.errors = errors;
    }
}
