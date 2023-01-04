package com.doneasy.don.service.project;


import com.doneasy.don.domain.project.ContentOfProjectReview;
import com.doneasy.don.domain.project.ProjectProposalReview;
import com.doneasy.don.dto.BoardSaveReDto;
import com.doneasy.don.dto.ContentReDto;
import com.doneasy.don.repository.project.ContentsOfProjectReview;
import com.doneasy.don.repository.project.ProjectReview;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {


    private final ProjectReview projectReview;
    private final ContentsOfProjectReview contentsOfProjectReview;



    @Value("${file.dir2}")
    private String path;

    public void saveRe(BoardSaveReDto boardSaveReDto, List<MultipartFile> multipartFileList) throws IOException {
        ProjectProposalReview instance = ProjectProposalReview.getInstance(boardSaveReDto);
        List<ContentReDto> contentReDtoList = boardSaveReDto.getContentReDtoList();
        projectReview.saveReview(instance);
        ProjectProposalReview recent = projectReview.findReviewRecent();
        Long id = recent.getId();
        for(int i =0; i< multipartFileList.size(); i++){
            MultipartFile multipartFile= multipartFileList.get(i);
            String imageName=multipartFile.getOriginalFilename();
            ContentOfProjectReview contentOfProject2=ContentOfProjectReview.getContentOfProjectReview(contentReDtoList.get(i),i+1,imageName,id );
            contentsOfProjectReview.saveContentOfProjectReview(contentOfProject2);
            multipartFile.transferTo(new File(path+imageName));
        }
    }

}
