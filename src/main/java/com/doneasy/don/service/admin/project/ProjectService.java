package com.doneasy.don.service.admin.project;

import com.doneasy.don.domain.project.*;
import com.doneasy.don.domain.user.Organization;
import com.doneasy.don.dto.admin.project.ProjectListDto;
import com.doneasy.don.dto.admin.project.ProjectProposalListDto;
import com.doneasy.don.repository.admin.project.ICommentOfProjectRepository;
import com.doneasy.don.repository.admin.project.IDonationOfProjectRepository;
import com.doneasy.don.repository.admin.project.IProjectProposalRepository;
import com.doneasy.don.repository.admin.project.ISupportOfProjectRepository;
import com.doneasy.don.repository.project.ProjectRepository;
import com.doneasy.don.repository.user.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectService {

    private final IProjectProposalRepository projectProposalRepository;
    private final ProjectRepository projectRepository;
    private final OrganizationRepository organizationRepository;
    private final IDonationOfProjectRepository donationOfProjectRepository;
    private final ISupportOfProjectRepository supportOfProjectRepository;
    private final ICommentOfProjectRepository commentOfProjectRepository;

    public void save(Long projectProposalId, Long organizationId) {
        projectRepository.save(projectProposalId, organizationId);
    }

    public List<ProjectProposalListDto> findAll() {
        List<ProjectProposalListDto> list = new ArrayList<>();
        List<ProjectProposal> projectProposalList = projectProposalRepository.findAll();

        for (ProjectProposal projectProposal : projectProposalList) {
            Long id = projectProposal.getOrganization_id();
            Organization findOrganization = organizationRepository.findById(id);
            list.add(new ProjectProposalListDto(projectProposal.getId(), projectProposal.getTitle(), findOrganization.getNickname(), projectProposal.getStatus().toString(), projectProposal.getCreated_date().toString()));
        }
        return list;
    }
    public List<ProjectProposalListDto> findByTitle(String search) {
        List<ProjectProposalListDto> list = new ArrayList<>();
        List<ProjectProposal> projectProposalList = projectProposalRepository.findByTitle(search);

        for (ProjectProposal projectProposal : projectProposalList) {
            Long id = projectProposal.getOrganization_id();
            Organization findOrganization = organizationRepository.findById(id);
            list.add(new ProjectProposalListDto(projectProposal.getId(), projectProposal.getTitle(), findOrganization.getNickname(), projectProposal.getStatus().toString(), projectProposal.getCreated_date().toString()));
        }
        return list;
    }

    public void statusToSuccess(Long id) {
    }

    public List<ProjectListDto> getProjectShowList() {
        List<Project> findAllProject = projectRepository.findAll();
        List<ProjectListDto> result = new ArrayList<>();

        for (Project project : findAllProject) {
            ProjectProposal findProjectProposal = projectProposalRepository.findById(project.getProjectProposal_id());
            Organization findOrganization = organizationRepository.findById(findProjectProposal.getOrganization_id());
            List<DonationOfProject> findDonation = donationOfProjectRepository.findByProjectId(project.getId());
            List<SupportOfProject> findSupport = supportOfProjectRepository.findByProjectId(project.getId());
            List<CommentOfProject> findCommentSupport = commentOfProjectRepository.findByProjectId(project.getId());

            int price = 0;
            int supportPrice = (findSupport.size() + findCommentSupport.size()) * 100;
            for (DonationOfProject donationOfProject : findDonation) {
                price += donationOfProject.getPrice();
            }
            result.add(new ProjectListDto(project.getId(), findProjectProposal.getTitle(), findOrganization.getNickname(), findOrganization.getAccount(), price, supportPrice, project.getStatus(), findProjectProposal.getDeadline().toString()));
        }
        return result;
    }

    public List<ProjectListDto> getProjectShowListByTitle(String title) {
        List<ProjectProposal> findProjectProposal = projectProposalRepository.findByTitleOnlySuccess(title);
        List<ProjectListDto> result = new ArrayList<>();

        for (ProjectProposal projectProposal : findProjectProposal) {
            Project findProject = projectRepository.findByProjectProposalId(projectProposal.getId());

            Organization findOrganization = organizationRepository.findById(projectProposal.getOrganization_id());
            List<DonationOfProject> findDonation = donationOfProjectRepository.findByProjectId(findProject.getId());
            List<SupportOfProject> findSupport = supportOfProjectRepository.findByProjectId(findProject.getId());
            List<CommentOfProject> findCommentSupport = commentOfProjectRepository.findByProjectId(findProject.getId());

            int price = 0;
            int supportPrice = (findSupport.size() + findCommentSupport.size()) * 100;
            for (DonationOfProject donationOfProject : findDonation) {
                price += donationOfProject.getPrice();
            }
            result.add(new ProjectListDto(findProject.getId(), projectProposal.getTitle(), findOrganization.getNickname(), findOrganization.getAccount(), price, supportPrice, findProject.getStatus(), projectProposal.getDeadline().toString()));
        }

        return result;
    }
}
