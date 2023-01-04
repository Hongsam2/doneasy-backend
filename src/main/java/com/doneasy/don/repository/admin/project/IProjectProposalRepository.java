package com.doneasy.don.repository.admin.project;

import com.doneasy.don.domain.project.Project;
import com.doneasy.don.domain.project.ProjectProposal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IProjectProposalRepository {

    List<ProjectProposal> findAll();
    ProjectProposal findById(Long id);
    List<ProjectProposal> findByTitle(String title);
    List<ProjectProposal> findByTitleOnlySuccess(String title);
    Boolean modifyStatusSuccess(Long id);
    Boolean modifyStatusFail(Long id);
}
