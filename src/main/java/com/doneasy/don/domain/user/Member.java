package com.doneasy.don.domain.user;

//import lombok.AllArgsConstructor;
import com.doneasy.don.service.user.MemberDateService;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
//@AllArgsConstructor
public class Member {

    private Long id;
    private String member_id;
    private String password;
    private String email;
    private String nickname;
    private String phoneNumber;
    private MemberStatus status;
    private Grade grade;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;



}
