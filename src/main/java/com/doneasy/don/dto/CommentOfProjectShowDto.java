package com.doneasy.don.dto;

import lombok.Data;


@Data
public class CommentOfProjectShowDto {
    private Long id;
    private String member_id;
    private String content;
    private String created_date;

}
