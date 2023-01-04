package com.doneasy.don.service.admin.comment;

import com.doneasy.don.domain.project.CommentOfProject;
import com.doneasy.don.dto.admin.comment.CommentListDto;
import com.doneasy.don.repository.admin.project.ICommentOfProjectRepository;
import com.doneasy.don.repository.admin.project.IReportOfCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final ICommentOfProjectRepository commentOfProjectRepository;
    private final IReportOfCommentRepository reportOfCommentRepository;

    public List<CommentListDto> findAll() {
        List<CommentListDto> result = new ArrayList<>();
        List<CommentOfProject> findCommentList = commentOfProjectRepository.findAll();
        for (CommentOfProject commentOfProject : findCommentList) {
            Long reports = reportOfCommentRepository.findByCommentOfProjectId(commentOfProject.getId());
            result.add(new CommentListDto(commentOfProject.getId(), commentOfProject.getContent(), reports, commentOfProject.getCreated_date().toString(), commentOfProject.getStatus().toString()));
        }
        return result;
    }

}
