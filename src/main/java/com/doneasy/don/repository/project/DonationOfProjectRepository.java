package com.doneasy.don.repository.project;

import com.doneasy.don.domain.project.DonationOfProject;
import com.doneasy.don.dto.project.DonationOfProjectDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonationOfProjectRepository {
    List<DonationOfProject> findByMemberId(Long member_id);

    List<DonationOfProjectDto> findAll();


}
