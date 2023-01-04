package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.CommentOfProject;
import com.doneasy.don.dto.CommentOfProjectShowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentOfProjectRepository {
    List<CommentOfProjectShowDto> findAllById(int id);

    Boolean saveComment(CommentOfProject commentOfProject);
}
