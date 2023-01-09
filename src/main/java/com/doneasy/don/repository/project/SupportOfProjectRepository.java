package com.doneasy.don.repository.project;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportOfProjectRepository {
    Integer findByMemberId(Long member_id);

}
