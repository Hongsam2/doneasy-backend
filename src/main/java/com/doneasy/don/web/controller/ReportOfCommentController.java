package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.ReportOfComment;
import com.doneasy.don.repository.project.ReportOfCommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/report-of-comment")
public class ReportOfCommentController {

    private final ReportOfCommentRepository reportOfCommentRepository;
    @PostMapping("/save-report")
    public ResponseEntity saveReportOfComment (@RequestBody ReportOfComment reportOfComment) {
        reportOfCommentRepository.saveReportOfComment(reportOfComment);
        return ResponseEntity.ok().build();
    }
}
