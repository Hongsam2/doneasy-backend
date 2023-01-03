package com.doneasy.don.domain.project;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class Project {

    private Long id;
    private Target target;
    private LocalDateTime deadline;
    private LocalDateTime serviceStartDate;
    private LocalDateTime serviceEndDate;
    private String title;
    private ProjectStatus status;
    private Integer targetPrice;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private Long organizationId;
}
