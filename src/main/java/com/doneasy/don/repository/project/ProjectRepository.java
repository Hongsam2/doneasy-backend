package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectRepository {

    Boolean save(Long projectProposalId, Long organizationId);
    List<Project> findAll();

    Project findByProjectProposalId(Long projectProposalId);
    Boolean statusToDone(Long id);
}
