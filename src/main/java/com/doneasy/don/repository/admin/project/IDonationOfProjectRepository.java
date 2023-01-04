package com.doneasy.don.repository.admin.project;

import com.doneasy.don.domain.project.DonationOfProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDonationOfProjectRepository {

    List<DonationOfProject> findByProjectId(Long projectId);
}
