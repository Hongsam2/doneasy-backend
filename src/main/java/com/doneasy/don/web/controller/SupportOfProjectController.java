package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.SupportOfProject;
import com.doneasy.don.repository.project.SupportOfProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/support-of-project")
public class SupportOfProjectController {

    private final SupportOfProjectRepository supportOfProjectRepository;
    @PostMapping("/save-support")
    public ResponseEntity saveSupport(@RequestBody SupportOfProject supportOfProject) {
        supportOfProjectRepository.saveSupport(supportOfProject);
        return ResponseEntity.ok().build();
    }
}
