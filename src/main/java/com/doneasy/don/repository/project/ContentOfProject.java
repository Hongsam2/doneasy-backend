package com.doneasy.don.repository.project;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContentOfProject {

    Boolean saveContent(com.doneasy.don.domain.project.ContentOfProject contentOfProject);

}