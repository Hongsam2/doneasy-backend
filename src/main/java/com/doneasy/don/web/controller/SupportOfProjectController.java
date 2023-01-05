package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.SupportOfProject;
import com.doneasy.don.dto.SupportOfProjectShowDto;
import com.doneasy.don.repository.project.SupportOfProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/support-of-project")
public class SupportOfProjectController {

    private final SupportOfProjectRepository supportOfProjectRepository;
    @PostMapping("/save-support")
    public ResponseEntity saveSupport(@RequestBody SupportOfProject supportOfProject) {
//        System.out.println(supportOfProject.getProject_id());
        supportOfProjectRepository.saveSupport(supportOfProject);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/get-support")
    public ResponseEntity getSupport(HttpServletRequest req, HttpServletResponse res, int id) {
//        System.out.println(id);
        List<SupportOfProjectShowDto> supportOfProjectList = supportOfProjectRepository.getSupport(id);
        return new ResponseEntity(supportOfProjectList, HttpStatus.OK);
    }
}
