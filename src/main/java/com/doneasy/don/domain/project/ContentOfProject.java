package com.doneasy.don.domain.project;

import com.doneasy.don.dto.BoardSaveDto;
import com.doneasy.don.dto.ContentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class ContentOfProject {



    private Long id;
    private String subtitle;
    private String contents;
    private String image_name;
    private Integer order_num;
    private ContentOfProjectStatus status;
    private LocalDateTime create_date;
    private LocalDateTime modifiedDate;
    private Long project_id;


    public static ContentOfProject getContentOfProject(ContentDto contentDto, int index,String image_name, Long project_id) {
        return new ContentOfProject(null, contentDto.getSubtitle(), contentDto.getContents(), image_name, index, ContentOfProjectStatus.ACTIVE, LocalDateTime.now(), LocalDateTime.now(), project_id);

    }




}
