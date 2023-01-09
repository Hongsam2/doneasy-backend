package com.doneasy.don.dto.organization;

import com.doneasy.don.dto.project.ProjectListDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
public class OrganizationDetailDto {
    private String email;
    private String nickname;
    private String phone_number;
    private byte[] image;
    private String introduction;
    private String zipcode;
    private String address;
    private int activeCount;
    private int doneCount;

    private List<ProjectListDto> projectListDtoList;
}
