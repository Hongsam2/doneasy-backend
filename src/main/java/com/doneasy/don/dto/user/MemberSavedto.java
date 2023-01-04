package com.doneasy.don.dto.user;

import lombok.Data;

@Data
public class MemberSavedto {
    private String member_id;
    private String password;
    private String email;
    private String nickname;
    private String phone_number;


}
