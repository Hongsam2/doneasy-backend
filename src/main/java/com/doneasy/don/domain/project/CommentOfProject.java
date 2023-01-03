package com.doneasy.don.domain.project;

import java.time.LocalDateTime;

public class CommentOfProject {

    private Long id;
    private String content;
    private int price;
    private CommentOfProjectStatus status;
    private LocalDateTime created_date;
    private Long member_id;
    private Long project_id;
}
