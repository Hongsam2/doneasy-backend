package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.DonationOfProject;
import com.doneasy.don.dto.DonationOfProjectShowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonationOfProjectRepository {
    List<DonationOfProjectShowDto> findAllById(int id);
}
