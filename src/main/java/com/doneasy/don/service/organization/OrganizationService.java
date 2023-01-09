package com.doneasy.don.service.organization;

import com.doneasy.don.domain.project.Project;
import com.doneasy.don.domain.project.ProjectProposal;
import com.doneasy.don.domain.user.Organization;
import com.doneasy.don.dto.organization.OrganizationDetailDto;
import com.doneasy.don.dto.project.ProjectListDto;
import com.doneasy.don.repository.project.ProjectProposalRepository;
import com.doneasy.don.repository.project.ProjectRepository;
import com.doneasy.don.repository.user.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationService {

    @Value("${file.dir}") private String path;

    private final OrganizationRepository organizationRepository;
    private final ProjectRepository projectRepository;
    private final ProjectProposalRepository projectProposalRepository;

    public OrganizationDetailDto getOrganizationDetail(String organization_id) throws IOException {
        Organization organization = organizationRepository.findByOrganizationId(organization_id);
        log.info(organization.getNickname());
        log.info(organization.getOrganization_id());
        log.info(organization.getAccount());
        List<Project> projectList = projectRepository.findByOrganizationId(organization.getId());
        int activeCount= 0;
        int doneCount= 0;

        List<ProjectListDto> list = new ArrayList<>();

        for (Project project : projectList) {
            if (project.getStatus().toString().equals("ACTIVE")) {
                activeCount++;
            } else {
                doneCount++;
            }
            ProjectProposal projectProposal = projectProposalRepository.findById(project.getProjectProposal_id());
            list.add(new ProjectListDto(projectProposal.getTitle(), project.getStatus().toString()));

        }

        return new OrganizationDetailDto(organization.getEmail(), organization.getNickname(),
                organization.getPhone_number(), getImage(organization.getImage_name()),
                organization.getIntroduction(), organization.getZipcode(), organization.getAddress(),
                activeCount, doneCount, list);
    }

    public byte[] getImage(String imageName) throws IOException {
        File file = new File(path + imageName);
        byte[] bytes = Files.readAllBytes(file.toPath());
        return bytes;
    }

}
