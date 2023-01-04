package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.ProjectProposalReview;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectReview {


    Boolean saveReview(ProjectProposalReview projectProposalReview);
    ProjectProposalReview findReviewRecent();
}
