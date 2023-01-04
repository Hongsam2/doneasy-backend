package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.SupportOfProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportOfProjectRepository {
    Boolean saveSupport(SupportOfProject supportOfProject);
}
