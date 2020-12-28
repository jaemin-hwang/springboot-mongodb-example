package com.jaemin.data.api.sample.exception;

import com.jaemin.data.api.common.exception.JaeminException;
import com.jaemin.data.api.common.exception.ErrorMessageCode;
import org.springframework.http.HttpStatus;

public class SampleValidException extends JaeminException {


    public SampleValidException() {
        super("SampleValidException");
    }

    public SampleValidException(String message) {
        super(message);
    }

    public SampleValidException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);

    }

    public SampleValidException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message, httpStatus, errorMessagerCode);
    }

    public SampleValidException(String message, ErrorMessageCode errorMessagerCode) {
        super(message, errorMessagerCode);
    }

    public SampleValidException(ErrorMessageCode errorMessagerCode) {
        super(errorMessagerCode);

    }

}
