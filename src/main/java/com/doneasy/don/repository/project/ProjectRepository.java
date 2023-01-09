package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectRepository {
    List<Project> findByOrganizationId(Long organization_id);
}
