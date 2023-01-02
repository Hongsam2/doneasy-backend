package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.ContentOfProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ContentOfProjectRepository {
    List<ContentOfProject> getAll();
    List<ContentOfProject> findAllByProjectId(int projectId);
}
