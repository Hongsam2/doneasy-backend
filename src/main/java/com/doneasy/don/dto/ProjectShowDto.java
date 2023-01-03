package com.doneasy.don.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class ProjectShowDto {
    private String title;
    private Date created_date;
    private Date deadline;
    private Date service_start_date;
    private Date service_end_date;
    private int target_price;
    private String nickname;
}
