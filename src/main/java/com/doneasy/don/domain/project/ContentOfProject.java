package com.doneasy.don.domain.project;

import java.time.LocalDateTime;

public class ContentOfProject {

    private Long id;
    private String subtitle;
    private String contents;
    private String imageName;
    private Integer order;
    private ContentOfProjectStatus status;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private Long projectId;
}
