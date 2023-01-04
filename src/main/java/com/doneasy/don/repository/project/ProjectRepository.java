package com.doneasy.don.repository.project;

import com.doneasy.don.dto.ProjectShowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectRepository {
    ProjectShowDto findProjectInfoByProjectId(int id);
}
