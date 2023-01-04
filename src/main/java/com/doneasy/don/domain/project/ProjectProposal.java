package com.doneasy.don.domain.project;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProjectProposal {

    private Long id;
    private Target target;
    private LocalDateTime deadline;
    private LocalDateTime service_start_date;
    private LocalDateTime service_end_date;
    private String title;
    private Integer target_price;
    private ProjectProposalStatus status;
    private LocalDateTime created_date;
    private Long organization_id;

}
