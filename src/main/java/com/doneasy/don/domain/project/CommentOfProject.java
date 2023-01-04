package com.doneasy.don.domain.project;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentOfProject {

    private Long id;
    private String content;
    private CommentOfProjectStatus status;
    private LocalDateTime created_date;
    private Long member_id;
    private Long project_id;
}
