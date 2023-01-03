package com.doneasy.don.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContentOfProjectShowDto {

    private Long id;
    private String subtitle;
    private String content;
    private String image_name;
    private int order_num;

}
