package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.ContentOfProject;
import com.doneasy.don.dto.ContentOfProjectShowDto;
import com.doneasy.don.repository.project.ContentOfProjectRepository;
import com.doneasy.don.service.ContentOfProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/content-of-project")
public class ContentOfProjectController {

    private final ContentOfProjectRepository contentOfProjectRepository;
    private final ContentOfProjectService contentOfProjectService;
    @PostMapping("/get-content")
    public ResponseEntity<List<ContentOfProject>> getContent(HttpServletRequest req, HttpServletResponse res, int id) throws IOException {
//        System.out.println(id);
        List<ContentOfProject> findContent = contentOfProjectRepository.findAllByProjectId(id);

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

}
