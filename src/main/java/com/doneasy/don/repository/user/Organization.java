package com.doneasy.don.repository.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface Organization {


String getOrganization (Long id);


}
