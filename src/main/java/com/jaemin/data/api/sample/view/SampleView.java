package com.jaemin.data.api.sample.view;

import com.jaemin.data.api.common.model.BaseView;
import com.jaemin.data.api.sample.constant.SampleStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class SampleView extends BaseView {

    private String title;
    private String contents;
    private SampleStatus status;

}
