package com.doneasy.don.web.controller;

import com.doneasy.don.dto.project.ProjectBoardShowdto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;

@Slf4j
@RestController
@RequestMapping("/projectBoard")
@RequiredArgsConstructor
public class ProjectBoardController {

    @PostMapping("/findAll")
    public ResponseEntity getProjectBoard() {

        ProjectBoardShowdto projectBoardShowdto = new ProjectBoardShowdto() {

            return ResponseEntity;
        }
    }

}
