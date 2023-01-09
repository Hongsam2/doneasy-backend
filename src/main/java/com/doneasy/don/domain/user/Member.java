package com.doneasy.don.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Member {

    private Long id;
    private String member_id;
    private String password;
    private String email;
    private String nickname;
    private String phone_number;
    private String status;
    private String grade;
    private LocalDate created_date;
    private LocalDate modified_date;


}
