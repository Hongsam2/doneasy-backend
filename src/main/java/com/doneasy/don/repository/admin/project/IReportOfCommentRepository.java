package com.doneasy.don.repository.admin.project;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IReportOfCommentRepository {

    Long findByCommentOfProjectId(Long id);
}
