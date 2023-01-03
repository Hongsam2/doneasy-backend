package com.doneasy.don.domain.user;

import java.time.LocalDateTime;

public class Member {

    private Long id;
    private String member_id;
    private String password;
    private String email;
    private String nickname;
    private String phone_number;
    private MemberStatus status;
    private Grade grade;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
}
