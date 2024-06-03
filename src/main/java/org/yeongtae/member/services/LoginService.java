package org.yeongtae.member.services;

import org.yeongtae.global.Service;
import org.yeongtae.member.MemberSession;
import org.yeongtae.member.controllers.RequestLogin;
import org.yeongtae.member.entities.Member;
import org.yeongtae.member.mapper.MemberMapper;
import org.yeongtae.member.validators.LoginValidator;

// LoginService 클래스: 각각 회원 가입과 로그인에 대한 비즈니스 로직을 처리하는 서비스 클래스입니다.
public class LoginService implements Service<RequestLogin> {

    private final LoginValidator validator;
    private final MemberMapper mapper;


    public LoginService(MemberMapper mapper, LoginValidator validator) {
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public void process(RequestLogin form) {
        // 로그인 유효성 검사 - 예외 발생하지 않으면 이상 없음
        validator.check(form);

        // 회원정보 조회
        Member member = mapper.get(form.getUserId());

        // 로그인 처리
        MemberSession.login(member);
    }
}
