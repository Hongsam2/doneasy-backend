package com.doneasy.don.web.controller;

import com.doneasy.don.domain.user.Member;
import com.doneasy.don.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping("/save")
    public ResponseEntity save(Member member){
        memberRepository.saveMember(member);
        System.out.println(member);
        return ResponseEntity.ok().build();
    }
}