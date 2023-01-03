package com.doneasy.don.service.project;

import com.doneasy.don.domain.project.ProjectProposal;
import com.doneasy.don.dto.BoardSaveDto;
import com.doneasy.don.dto.ContentDto;
import com.doneasy.don.repository.project.ContentOfProject;
import com.doneasy.don.repository.project.ProjectProposalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectProposalService {


    private final ProjectProposalRepository projectProposalRepository;


private final ContentOfProject contentOfProject;

    @Value("${file.dir}")
    private String path;

    public void save(BoardSaveDto boardSaveDto, List<MultipartFile> multipartFileList) throws IOException {
        ProjectProposal instance = ProjectProposal.getInstance(boardSaveDto);
        List<ContentDto> contentDtoList = boardSaveDto.getContentDtoList();
        projectProposalRepository.saveProject(instance);

        ProjectProposal recent = projectProposalRepository.findRecent();
        Long id = recent.getId();

        for (int i=0; i< multipartFileList.size(); i++) {
    MultipartFile multipartFile= multipartFileList.get(i);

          String imageName= multipartFile.getOriginalFilename();

            com.doneasy.don.domain.project.ContentOfProject contentOfProject1 = com.doneasy.don.domain.project.ContentOfProject.getContentOfProject(contentDtoList.get(i), i + 1, imageName, id);
            contentOfProject.saveContent(contentOfProject1);

            multipartFile.transferTo(new File(path + imageName));

        }


    }

}
