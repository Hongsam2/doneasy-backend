package com.doneasy.don.domain.campaign;

import java.time.LocalDateTime;

public class Campaign {

    private Long id;
    private String howToUseFirst;
    private String howToUseSecond;
    private String howToUseThird;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer goal;
    private String word;
    private CampaignStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long organizationId;
}
