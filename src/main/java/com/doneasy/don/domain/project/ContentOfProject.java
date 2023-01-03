package com.doneasy.don.domain.project;

import java.time.LocalDateTime;

public class ContentOfProject {

    private Long id;
    private String subtitle;
    private String content;
    private String image_name;
    private Integer order_num;
    private ContentOfProjectStatus status;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private Long project_id;
}
