package com.doneasy.don.web.controller;

import com.doneasy.don.dto.BoardSaveDto;
import com.doneasy.don.repository.project.ProjectProposalRepository;
import com.doneasy.don.service.project.ProjectProposalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final ProjectProposalRepository projectProposalRepositoryRe;
    private final com.doneasy.don.repository.project.ContentOfProject contentOfProjectRe;
    private final ProjectProposalService projectProposalService;

//    @PostMapping("/save")
//    public ResponseEntity seveBoard(BoardSaveDto boardSaveDto, @RequestPart(value = "image") List<MultipartFile> multipartFiles) throws IOException {
//        ContentOfProject contentOfProject = ContentOfProject.getContentOfProject(boardSaveDto);
//        contentOfProjectRe.saveContent(contentOfProject);
//        com.doneasy.don.domain.project.ProjectProposal projectProposal = com.doneasy.don.domain.project.ProjectProposal.getProjectProposal(boardSaveDto);
//        projectProposalRe.saveProject(projectProposal);
//
//        ContentOfProject recent = contentOfProjectRe.findRecent();
//        ImageService.save(multipartFiles, recent.getId());
//        return new ResponseEntity(HttpStatus.OK);


//    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestPart("boardSaveDto") BoardSaveDto boardSaveDto, @RequestPart("imageList") List<MultipartFile> multipartFileList) throws IOException {


        projectProposalService.save(boardSaveDto, multipartFileList);











//        ContentOfProject contentOfProject1=ContentOfProject.getContentOfProject(boardSaveDto);
//        contentOfProjectRe.saveContent(contentOfProject1)
//        com.doneasy.don.domain.project.ProjectProposal projectProposal1=com.doneasy.don.domain.project.ProjectProposal.getProjectProposal(boardSaveDto);
//        projectProposalRe.saveProject((com.doneasy.don.domain.project.ProjectProposal) projectProposal1);


//        System.out.println(boardSaveDto.getTitle());
//        System.out.println(boardSaveDto.getService_start_date());
//        List<ContentDto> contentDtoList = boardSaveDto.getContentDtoList();
//
//        System.out.println(contentDtoList.size());
//        for (ContentDto contentDto : contentDtoList) {
//            System.out.println(contentDto.getSubtitle());
//            System.out.println(contentDto.getContents());
//        }
//        System.out.println(multipartFileList.get(0).getOriginalFilename());




        return ResponseEntity.ok().build();
    }


}
