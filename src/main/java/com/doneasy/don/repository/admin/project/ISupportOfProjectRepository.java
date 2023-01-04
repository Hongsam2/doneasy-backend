package com.doneasy.don.repository.admin.project;

import com.doneasy.don.domain.project.SupportOfProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISupportOfProjectRepository {

    List<SupportOfProject> findByProjectId(Long projectId);
}
