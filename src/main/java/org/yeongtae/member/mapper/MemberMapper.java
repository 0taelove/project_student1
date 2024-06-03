package org.yeongtae.member.mapper;

import org.yeongtae.member.controllers.SearchMember;
import org.yeongtae.member.entities.Member;

import java.util.List;

// MemberMapper 인터페이스: 회원 정보에 대한 데이터베이스 연산을 담당하는 Mapper 인터페이스입니다.
public interface MemberMapper {
    List<Member> getList(SearchMember search);
    Member get(String userId);
    long getTotal(SearchMember search);
    int exist(String userId);
    int register(Member member);
    int modify(Member member);
    int delete(String userId);
}
