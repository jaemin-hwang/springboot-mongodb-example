package com.jaemin.data.api.common.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class JaeminErrors implements Serializable {
    private int code;
    private String message;
    private List<JaeminError> errors = new ArrayList<>();

    @JsonCreator
    public JaeminErrors(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void add(String path, int code, String message) {
        this.errors.add(new JaeminError(path, code, message));
    }
}

