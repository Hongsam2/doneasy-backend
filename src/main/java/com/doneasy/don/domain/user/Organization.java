package com.doneasy.don.domain.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Organization {

    private Long id;
    private String organizationId;
    private String password;
    private String email;
    private String nickname;
    private String phone_number;
    private String imageName;
    private String introduction;
    private String zipcode;
    private String address;
    private String account;
    private String bank;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
