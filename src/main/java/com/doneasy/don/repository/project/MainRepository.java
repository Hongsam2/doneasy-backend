package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.DonationOfProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainRepository {
    DonationOfProject findById(Long id);
}
