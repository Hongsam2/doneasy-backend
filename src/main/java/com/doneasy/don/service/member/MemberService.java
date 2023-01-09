package com.doneasy.don.service.member;

import com.doneasy.don.domain.project.DonationOfProject;
import com.doneasy.don.domain.user.Member;
import com.doneasy.don.dto.member.MemberDetailDto;
import com.doneasy.don.repository.project.CommentOfProjectRepository;
import com.doneasy.don.repository.project.DonationOfProjectRepository;
import com.doneasy.don.repository.project.SupportOfProjectRepository;
import com.doneasy.don.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final CommentOfProjectRepository commentOfProjectRepository;
    private final DonationOfProjectRepository donationOfProjectRepository;
    private final SupportOfProjectRepository supportOfProjectRepository;
    private final MemberRepository memberRepository;

    public MemberDetailDto getMemberDetail(String memberId){
        Member findMember = memberRepository.findByMemberId(memberId);
        Long id = findMember.getId();
        log.info("id: {}", id);
        Integer countComment = commentOfProjectRepository.findByMemberId(id);
        Integer countSupport = supportOfProjectRepository.findByMemberId(id);
        List<DonationOfProject> donationList = donationOfProjectRepository.findByMemberId(id);

        int price= 0;
        for (DonationOfProject donationOfProject : donationList) {
            price += donationOfProject.getPrice();
        }

        return new MemberDetailDto(findMember.getNickname(), donationList.size(), price, countSupport, countComment);


    }


}
