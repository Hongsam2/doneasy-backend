package com.doneasy.don.repository.user;

import com.doneasy.don.domain.user.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {


    Boolean saveMember(Member member);
}
