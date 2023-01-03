package com.doneasy.don.domain.project;

import java.time.LocalDateTime;

public class Project {

    private Long id;
    private Target target;
    private LocalDateTime deadline;
    private LocalDateTime service_start_date;
    private LocalDateTime service_end_date;
    private String title;
    private ProjectStatus status;
    private Integer target_price;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private Long organization_id;
}
