package com.doneasy.don.domain.project;

import java.time.LocalDateTime;

public class CommentOfProject {

    private Long id;
    private String contents;
    private int price;
    private CommentOfProjectStatus status;
    private LocalDateTime createdDate;
    private Long memberId;
    private Long projectId;
}
