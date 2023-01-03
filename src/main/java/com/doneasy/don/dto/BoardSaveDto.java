package com.doneasy.don.dto;

import com.doneasy.don.domain.project.ContentOfProjectStatus;
import com.doneasy.don.domain.project.Target;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardSaveDto {





    private String service_start_date;


    private String service_end_date;
    private String deadline;
    private String category;
    private Integer target_price;
    private String title;
    private List<ContentDto> contentDtoList;

//   private String subtitle;
//    private String contents;



}
