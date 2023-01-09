package com.doneasy.don.domain.project;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DonationOfProject {

    private Long id;
    private Integer price;
    private LocalDateTime createdDate;
    private Long memberId;
    private Long projectId;
}
