package com.doneasy.don.domain.project;


import com.doneasy.don.dto.ContentReDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ContentOfProjectReview {


    private Long id;
    private String subtitle;
    private String contents;
    private String image_name;
    private Integer order_num;
    private ContentOfProjectStatus status;
    private LocalDateTime create_date;
    private LocalDateTime modifiedDate;
    private Long projectreview_id;


    public static ContentOfProjectReview getContentOfProjectReview(ContentReDto contentReDto, int index, String image_name, Long projectreview_id){
        return new ContentOfProjectReview(null,contentReDto.getSubtitle(),contentReDto.getContents(),image_name,index,ContentOfProjectStatus.ACTIVE,LocalDateTime.now(),LocalDateTime.now(),projectreview_id);
    }
}
