package com.jaemin.data.api.common.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
public class BaseEntity implements Serializable {

    @Id
    private String id;

    private ActiveType active = ActiveType.ACTIVE;
    private Long createdAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    private Long updatedAt = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();

    private Long createdId;
    private Long updatedId;


}
