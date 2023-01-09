package com.doneasy.don.web.controller;

import com.doneasy.don.domain.user.Member;
import com.doneasy.don.dto.member.MemberDetailDto;
import com.doneasy.don.repository.user.MemberRepository;
import com.doneasy.don.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/detail")
    public ResponseEntity<MemberDetailDto> memberDetail() {
        MemberDetailDto memberDetail = memberService.getMemberDetail("abc123");
        return new ResponseEntity<>(memberDetail, HttpStatus.OK);


    }
}
