package org.yeongtae.member.validators;

import org.yeongtae.global.exceptions.ValidationException;
import org.yeongtae.global.validators.RequiredValidator;
import org.yeongtae.global.validators.Validator;
import org.yeongtae.member.controllers.RequestJoin;
import org.yeongtae.member.mapper.MemberMapper;

// JoinValidator 클래스: 회원 가입 및 로그인 요청에 대한 유효성 검사를 수행하는 Validator 클래스입니다.
public class JoinValidator implements Validator<RequestJoin>, RequiredValidator {

    private final MemberMapper mapper;

    public JoinValidator(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void check(RequestJoin form) {
        // 필수 항목 체크 S
        String userId = form.getUserId();
        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();
        String userNm = form.getUserNm();

        checkRequired(userId, new ValidationException("아이디를 입력하세요."));
        checkRequired(userPw, new ValidationException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new ValidationException("비밀번호 확인을 입력하세요."));
        checkRequired(userNm, new ValidationException("회원명을 입력하세요."));
        // 필수 항목 체크 E

        // 아이디 자리수 체크(6자리 이상)
        if (userId == null || userId.length() < 6) {
            throw new ValidationException("아이디는 6자리 이상 입력하세요.");
        }

        // 아이디 중복 여부 체크
        if (mapper.exist(userId) > 0) {
            throw new ValidationException("이미 등록된 아이디 입니다.");
        }

        // 비밀번호 자리수 체크(8자리 이상)
        if (userPw == null || userPw.length() < 8) {
            throw new ValidationException("비밀번호는 8자리 이상 입력하세요.");
        }

        // 비밀번호, 비밀번호 확인 일치 여부 체크
        if (userPw != null && confirmPw != null && !userPw.equals(confirmPw)) {
            throw new ValidationException("비밀번호가 일치하지 않습니다.");
        }
    }
}
