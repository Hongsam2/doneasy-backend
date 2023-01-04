package com.doneasy.don.domain.project;


import com.doneasy.don.dto.BoardSaveDto;
import com.doneasy.don.dto.BoardSaveReDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProjectProposalReview {


    private Long id;
    private String title;
    private LocalDateTime create_date;
    private Long organization_id;
    private Long project_id;



    public static ProjectProposalReview getInstance(BoardSaveReDto boardSaveReDto){
        return new ProjectProposalReview(null, boardSaveReDto.getTitle(), LocalDateTime.now(),null,null);
    }
}
