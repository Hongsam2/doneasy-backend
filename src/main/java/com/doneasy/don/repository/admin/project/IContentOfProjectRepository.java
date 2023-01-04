package com.doneasy.don.repository.admin.project;

import com.doneasy.don.domain.project.ContentOfProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IContentOfProjectRepository {

    List<ContentOfProject> findByProjectProposalId(Long id);
}
