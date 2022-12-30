package com.doneasy.don.domain.campaign;

import java.time.LocalDateTime;

public class ContentOfCampaign {

    private Long id;
    private String subtitle;
    private String contents;
    private String imageName;
    private Integer order;
    private ContentOfCampaignStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long campaignId;
}
