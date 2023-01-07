package com.doneasy.don.dto;

import lombok.Data;

@Data
public class DonationOfProjectShowDto {
    private Long id;
    private Long price;
    private String created_date;
    private String memberId;
}
