package com.doneasy.don.service.project;

import com.doneasy.don.domain.project.ProjectProposal;
import com.doneasy.don.dto.BoardSaveDto;
import com.doneasy.don.dto.ContentDto;
import com.doneasy.don.repository.project.ContentOfProject;
import com.doneasy.don.repository.project.ProjectProposalRepository;
import com.doneasy.don.repository.user.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;


@Service
@RequiredArgsConstructor
public class ProjectProposalService {


    private final ProjectProposalRepository projectProposalRepository;

    private final Organization organization;
    private final ContentOfProject contentOfProject;

    @Value("${file.dir}")
    private String path;

    @Value("${pdf.dir}")
    private String path2;

    public void save(BoardSaveDto boardSaveDto, List<MultipartFile> multipartFileList) throws IOException {
        ProjectProposal instance = ProjectProposal.getInstance(boardSaveDto);
        List<ContentDto> contentDtoList = boardSaveDto.getContentDtoList();
        //인설트 쿼리문을 날려서 db 에 저장한것.
        projectProposalRepository.saveProject(instance);


        //db 에 sql 을 날려서 결과값을 가져온다.
        ProjectProposal recent = projectProposalRepository.findRecent();

        //편하게 쓸려고 담음
        Long id = recent.getId();
        System.out.println(recent.getOrganization_id());
        for (int i = 0; i < multipartFileList.size(); i++) {
            MultipartFile multipartFile = multipartFileList.get(i);

            StringTokenizer st = new StringTokenizer(multipartFile.getOriginalFilename(), ".");
            st.nextToken();
            if (st.nextToken().equals("pdf")) {
                multipartFile.transferTo(new File(path2 + organization.getOrganization(recent.getOrganization_id()) + ".pdf"));
                multipartFileList.remove(i);
                break;

            }
        }


        for (int i = 0; i < multipartFileList.size(); i++) {
            MultipartFile multipartFile = multipartFileList.get(i);

            //get오리지날 파일 네임 스트링 파일네임을 받아서 . 을 기준으로 쪼개겠다.





            String imageName = multipartFile.getOriginalFilename();

            com.doneasy.don.domain.project.ContentOfProject contentOfProject1 =
                    com.doneasy.don.domain.project.ContentOfProject.getContentOfProject(contentDtoList.get(i), i + 1, imageName, id);
            contentOfProject.saveContent(contentOfProject1);
            multipartFile.transferTo(new File(path + imageName));
        }


    }

}