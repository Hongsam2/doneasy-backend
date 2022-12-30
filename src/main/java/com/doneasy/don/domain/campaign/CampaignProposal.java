package com.doneasy.don.domain.campaign;

import java.time.LocalDateTime;

public class CampaignProposal {

    private Long id;
    private String howToUseFirst;
    private String howToUseSecond;
    private String howToUseThird;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int goal;
    private String word;
    private CampaignProposalStatus status;
    private LocalDateTime createdDate;
    private Long organizationId;
}
