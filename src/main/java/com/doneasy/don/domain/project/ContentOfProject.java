package com.doneasy.don.domain.project;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ContentOfProject {

    private Long id;
    private String subtitle;
    private String content;
    private String image_name;
    private Integer order_num;
    private String created_date;
    private String modified_date;
    private Long project_id;
}
