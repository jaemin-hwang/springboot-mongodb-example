package com.jaemin.data.api.sample.model;

import com.jaemin.data.api.common.model.BaseEntity;
import com.jaemin.data.api.sample.constant.SampleStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@EqualsAndHashCode(callSuper = false)
@Document
@Builder
public class Sample extends BaseEntity {

    private String title;
    private String contents;

    @Builder.Default
    private SampleStatus status = SampleStatus.INIT;


}
