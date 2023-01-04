package com.doneasy.don.web.controller.admin;

import com.doneasy.don.dto.admin.comment.CommentListDto;
import com.doneasy.don.repository.admin.project.ICommentOfProjectRepository;
import com.doneasy.don.service.admin.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class CommentController {

    private final CommentService commentService;
    private final ICommentOfProjectRepository commentOfProjectRepository;

    @GetMapping("/comment")
    public ResponseEntity<List<CommentListDto>> getAll() {
        List<CommentListDto> all = commentService.findAll();
        // 지워야 할 것 TODO
        all.add(new CommentListDto(1L, "지금 이순간", 36L, "2020-01-01", "ACTIVE"));
        all.add(new CommentListDto(2L, "갑자기 조승우 생각", 1L, "2020-02-07", "ACTIVE"));
        all.add(new CommentListDto(3L, "경제환 노래 좋다", 17L, "2022-01-01", "ACTIVE"));
        all.add(new CommentListDto(4L, "people i don't like", 490L, "2023-01-05", "ACTIVE"));
        all.add(new CommentListDto(5L, "hello it's so good to see you", 290L, "1984-01-01", "ACTIVE"));
        return new ResponseEntity(all, HttpStatus.OK);
    }

    @PostMapping("/comment/blind")
    public ResponseEntity statusToBlind(@RequestBody HashMap<String, Long> map) {
        Long id = map.get("id");
        commentOfProjectRepository.statusToBlind(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
