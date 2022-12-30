package com.doneasy.don.domain.user;

import java.time.LocalDateTime;

public class Member {

    private Long id;
    private String memberId;
    private String password;
    private String email;
    private String nickname;
    private String phoneNumber;
    private MemberStatus status;
    private Grade grade;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
