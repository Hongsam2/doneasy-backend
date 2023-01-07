package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.ContentOfProject;
import com.doneasy.don.dto.*;
import com.doneasy.don.repository.project.*;
import com.doneasy.don.service.ContentOfProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/project-review")
public class ProjectReviewController {
    private final ProjectRepository projectRepository;
    private final ContentOfProjectRepository contentOfProjectRepository;
    private final CommentOfProjectRepository commentOfProjectRepository;
    private final SupportOfProjectRepository supportOfProjectRepository;
    private final ContentOfProjectService contentOfProjectService;
    private final DonationOfProjectRepository donationOfProjectRepository;

    @PostMapping("/get-project")
    public ResponseEntity getProject(HttpServletRequest req, HttpServletResponse res, int id) {
//        System.out.println(id);
        ProjectShowDto findProjectInfo = projectRepository.findProjectInfoByProjectId(id);

        return new ResponseEntity(findProjectInfo, HttpStatus.OK);
    }

    @PostMapping("/get-content")
    public ResponseEntity<List<ContentOfProject>> getContent(HttpServletRequest req, HttpServletResponse res, int id) throws IOException {

        List<ContentOfProject> findContent = contentOfProjectRepository.findContentForProjectReview(id);

        List<String> imageName = new ArrayList<>();
        for (int i = 0; i < findContent.size(); i++) {
            imageName.add(findContent.get(i).getImage_name());
        }

        List<byte[]> array = contentOfProjectService.getByteArray(imageName);
        List<ContentOfProjectShowDto> list = new ArrayList<>();
        for (ContentOfProject ofProject : findContent) {
            list.add(new ContentOfProjectShowDto(ofProject.getId(), ofProject.getSubtitle(), ofProject.getContent(), array.get(findContent.indexOf(ofProject)), ofProject.getOrder_num()));
        }

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/get-comment")
    public ResponseEntity getComment(HttpServletRequest req, HttpServletResponse res, int id) {
//        System.out.println(id);
        List<CommentOfProjectShowDto> showComment = commentOfProjectRepository.findAllById(id);
        return new ResponseEntity(showComment, HttpStatus.OK);
    }

    @PostMapping("/get-support")
    public ResponseEntity getSupport(HttpServletRequest req, HttpServletResponse res, int id) {
//        System.out.println(id);
        List<SupportOfProjectShowDto> supportOfProjectList = supportOfProjectRepository.getSupport(id);
        return new ResponseEntity(supportOfProjectList, HttpStatus.OK);
    }

    @PostMapping("/get-donation")
    public ResponseEntity getDonator(HttpServletRequest req, HttpServletResponse res, int id) {

        List<DonationOfProjectShowDto> donationOfProjectList = donationOfProjectRepository.findAllById(id);

        return new ResponseEntity(donationOfProjectList, HttpStatus.OK);
    }
}
