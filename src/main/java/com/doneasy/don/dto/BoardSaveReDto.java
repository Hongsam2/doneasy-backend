package com.doneasy.don.dto;


import lombok.Data;

import java.util.List;

@Data
public class BoardSaveReDto {

    private String title;
    private List<ContentReDto> contentReDtoList;

}
