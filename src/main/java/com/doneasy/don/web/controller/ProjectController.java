package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.Project;
import com.doneasy.don.domain.user.Organization;
import com.doneasy.don.dto.ProjectShowDto;
import com.doneasy.don.repository.project.ProjectRepository;
import com.doneasy.don.repository.user.OrganizationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectRepository projectRepository;

    @PostMapping("/get-project")
    public ResponseEntity getProject(HttpServletRequest req, HttpServletResponse res, int id) {
        System.out.println(id);
        ProjectShowDto findProjectInfo = projectRepository.findProjectInfoByProjectId(id);

        return new ResponseEntity(findProjectInfo, HttpStatus.OK);
    }
}
