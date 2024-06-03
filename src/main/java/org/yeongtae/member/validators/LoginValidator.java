package org.yeongtae.member.validators;

import org.yeongtae.global.exceptions.ValidationException;
import org.yeongtae.global.validators.RequiredValidator;
import org.yeongtae.global.validators.Validator;
import org.yeongtae.member.controllers.RequestLogin;
import org.yeongtae.member.entities.Member;
import org.yeongtae.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

// LoginValidator 클래스: 회원 가입 및 로그인 요청에 대한 유효성 검사를 수행하는 Validator 클래스입니다.
public class LoginValidator implements Validator<RequestLogin>, RequiredValidator {

    private final MemberMapper mapper;

    public LoginValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }
    /**
     * 1. 아이디, 비밀번호 필수 입력 유효성 체크
     * 2. 아이디로 조회된 회원이 있는지 체크
     * 3. 조회된 회원 데이터의 비밀번호와 사용자가 입력한 비밀번호 일치 여부 체크(BCrypt 해시 검증)
     * @param form
     */
    @Override
    public void check(RequestLogin form) {
        String userId = form.getUserId();
        String userPw = form.getUserPw();

        // 아이디, 비밀번호 필수 입력 유효성 체크
        checkRequired(userId, new ValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new ValidationException("비밀번호를 입력하세요."));

        // 아이디로 조회된 회원이 있는지, 있다면 비밀번호가 일치하는지 체크
        String message = "아이디 또는 비밀번호가 일치하지 않습니다.";
        Member member = mapper.get(userId);
        if (member == null || !BCrypt.checkpw(userPw, member.getUserPw())) {
            throw new ValidationException(message);
        }
    }
}
