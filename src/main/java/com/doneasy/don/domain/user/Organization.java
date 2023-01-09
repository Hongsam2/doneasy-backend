package com.doneasy.don.domain.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Organization {

    private Long id;
    private String organization_id;
    private String password;
    private String email;
    private String nickname;
    private String phone_number;
    private String image_name;
    private String introduction;
    private String zipcode;
    private String address;
    private String account;
    private String bank;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
}
