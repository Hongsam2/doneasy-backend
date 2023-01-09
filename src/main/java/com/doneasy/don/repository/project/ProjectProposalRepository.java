package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.ProjectProposal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectProposalRepository {
    ProjectProposal findById(Long id);
}
