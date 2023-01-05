package com.doneasy.don.web.controller;

import com.doneasy.don.domain.project.CommentOfProject;
import com.doneasy.don.dto.CommentOfProjectShowDto;
import com.doneasy.don.repository.project.CommentOfProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/comment-of-project")
public class CommentOfProjectController {

    private final CommentOfProjectRepository commentOfProjectRepository;

    @PostMapping("/get-comment")
    public ResponseEntity getComment(HttpServletRequest req, HttpServletResponse res, int id) {
//        System.out.println(id);
        List<CommentOfProjectShowDto> showComment = commentOfProjectRepository.findAllById(id);
        return new ResponseEntity(showComment, HttpStatus.OK);
    }

    @PostMapping("/save-comment")
    public ResponseEntity saveComment(@RequestBody CommentOfProject commentOfProject) {
        commentOfProjectRepository.saveComment(commentOfProject);
        return ResponseEntity.ok().build();
    }

}
