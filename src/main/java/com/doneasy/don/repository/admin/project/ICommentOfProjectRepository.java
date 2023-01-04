package com.doneasy.don.repository.admin.project;

import com.doneasy.don.domain.project.CommentOfProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICommentOfProjectRepository {

    List<CommentOfProject> findByProjectId(Long projectId);
}
