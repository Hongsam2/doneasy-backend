package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.Image;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IImageRepository {

    Boolean save(Image image);
}
