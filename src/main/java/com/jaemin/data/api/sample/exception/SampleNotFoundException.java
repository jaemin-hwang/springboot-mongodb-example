package com.jaemin.data.api.sample.exception;

import com.jaemin.data.api.common.exception.JaeminException;
import com.jaemin.data.api.common.exception.ErrorMessageCode;
import org.springframework.http.HttpStatus;

public class SampleNotFoundException extends JaeminException {


    public SampleNotFoundException() {
        super("SampleNotFoundException", ErrorMessageCode.SAMPLE_NOT_FOUND);
    }

    public SampleNotFoundException(String message) {
        super(message);
    }

    public SampleNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);

    }

    public SampleNotFoundException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message, httpStatus, errorMessagerCode);
    }

    public SampleNotFoundException(String message, ErrorMessageCode errorMessagerCode) {
        super(message, errorMessagerCode);
    }

    public SampleNotFoundException(ErrorMessageCode errorMessagerCode) {
        super(errorMessagerCode);

    }

}
