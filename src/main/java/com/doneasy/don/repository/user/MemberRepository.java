package com.doneasy.don.repository.user;

import com.doneasy.don.domain.user.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
    Member findByMemberId(String member_id);
}
