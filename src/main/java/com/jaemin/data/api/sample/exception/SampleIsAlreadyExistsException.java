package com.jaemin.data.api.sample.exception;

import com.jaemin.data.api.common.exception.JaeminException;
import com.jaemin.data.api.common.exception.ErrorMessageCode;
import org.springframework.http.HttpStatus;

public class SampleIsAlreadyExistsException extends JaeminException {


    public SampleIsAlreadyExistsException() {
        super("SampleIsAlreadyExistsException", ErrorMessageCode.SAMPLE_IS_ALREADY_EXISTS);
    }

    public SampleIsAlreadyExistsException(String message) {
        super(message);
    }

    public SampleIsAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);

    }

    public SampleIsAlreadyExistsException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message, httpStatus, errorMessagerCode);
    }

    public SampleIsAlreadyExistsException(String message, ErrorMessageCode errorMessagerCode) {
        super(message, errorMessagerCode);
    }

    public SampleIsAlreadyExistsException(ErrorMessageCode errorMessagerCode) {
        super(errorMessagerCode);

    }

}
