package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.SupportOfProject;
import com.doneasy.don.dto.SupportOfProjectShowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupportOfProjectRepository {
    Boolean saveSupport(SupportOfProject supportOfProject);
    List<SupportOfProjectShowDto> getSupport(int id);
}
