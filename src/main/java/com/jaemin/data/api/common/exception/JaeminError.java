package com.jaemin.data.api.common.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class JaeminError implements Serializable {
    private String path;
    private int code;
    private String message;

    @JsonCreator
    public JaeminError(String path, int code, String message) {
        this.path = path;
        this.code = code;
        this.message = message;
    }

}
