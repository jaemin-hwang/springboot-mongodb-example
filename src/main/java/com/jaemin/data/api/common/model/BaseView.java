package com.jaemin.data.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseView implements Serializable {

    private String id;
    private ActiveType active;
    private Long updatedAt;
    private Long createdAt;
    private Long createdId;
    private Long updatedId;

}
