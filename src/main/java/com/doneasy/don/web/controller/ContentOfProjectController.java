package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.ContentOfProject;
import com.doneasy.don.dto.ContentOfProjectShowDto;
import com.doneasy.don.repository.project.ContentOfProjectRepository;
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

    private final ContentOfProjectRepository contentOfProject;
    @PostMapping("/get-content")
    public ResponseEntity<List<ContentOfProject>> getContent(HttpServletRequest req, HttpServletResponse res, @RequestBody HashMap<String, Object> map) throws IOException {
        Integer id = Integer.parseInt((String)map.get("id"));
        System.out.println(id);
        List<ContentOfProject> findContent = contentOfProject.findAllByProjectId(id);
        List<ContentOfProjectShowDto> list = new ArrayList<>();
        for (ContentOfProject ofProject : findContent) {
            list.add(new ContentOfProjectShowDto(ofProject.getSubtitle(), ofProject.getContent(), ofProject.getImage_name(), ofProject.getOrder_num()));
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
