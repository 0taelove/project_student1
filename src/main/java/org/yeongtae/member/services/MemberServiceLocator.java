package org.yeongtae.member.services;

import org.yeongtae.global.AbstractServiceLocator;
import org.yeongtae.global.Service;
import org.yeongtae.global.ServiceLocator;
import org.yeongtae.global.configs.DBConn;
import org.yeongtae.global.constants.MainMenu;
import org.yeongtae.member.mapper.MemberMapper;
import org.yeongtae.member.validators.JoinValidator;
import org.yeongtae.member.validators.LoginValidator;

// MemberServiceLocator 클래스: 요청에 따른 적절한 서비스를 찾아 반환하는 클래스입니다.
public class MemberServiceLocator extends AbstractServiceLocator {

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new MemberServiceLocator();
        }

        return instance;
    }

    // 회원가입 유효성 검사 Validator
    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    // 로그인 유효성 검사 Validator
    public LoginValidator loginValidator() {
        return new LoginValidator(memberMapper());
    }

    // MemberMapper 인터페이스 구현체
    public MemberMapper memberMapper() {
        return DBConn.getSession().getMapper(MemberMapper.class);
    }

    @Override
    public Service find(MainMenu mainMenu) {
        Service service = services.get(mainMenu);
        if (service != null) {
            return service;
        }

        switch (mainMenu) {
            case JOIN: service = new JoinService(memberMapper(), joinValidator()); break;
            case LOGIN: service = new LoginService(memberMapper(), loginValidator()); break;
        }

        services.put(mainMenu, service);

        return service;
    }
}
