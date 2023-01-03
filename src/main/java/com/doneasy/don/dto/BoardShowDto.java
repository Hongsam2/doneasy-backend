package com.doneasy.don.dto;

import com.doneasy.don.domain.project.ContentOfProjectStatus;
import com.doneasy.don.domain.project.Target;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class BoardShowDto {

    private Long id;
    private Integer targetPrice;
    private Target target;
    private String title;
    private String subtitle;
    private String contents;
    private ContentOfProjectStatus status;
    private LocalDateTime createDate;
    private LocalDateTime deadline;
    private LocalDateTime serviceStartDate;
    private LocalDateTime serviceEndDate;
    private byte[] image;


}
