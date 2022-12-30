package com.doneasy.don.domain.project;

import java.time.LocalDateTime;

public class ProjectProposal {

    private Long id;
    private Target target;
    private LocalDateTime deadline;
    private LocalDateTime serviceStartDate;
    private LocalDateTime serviceEndDate;
    private String title;
    private Integer targetPrice;
    private ProjectProposalStatus status;
    private LocalDateTime createDate;
    private Long memberId;
}
