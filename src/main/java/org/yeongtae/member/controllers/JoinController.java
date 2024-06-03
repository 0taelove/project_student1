package org.yeongtae.member.controllers;

import org.yeongtae.global.AbstractController;
import org.yeongtae.global.Router;
import org.yeongtae.global.Service;
import org.yeongtae.global.constants.MainMenu;
import org.yeongtae.main.MainRouter;
import org.yeongtae.member.services.MemberServiceLocator;
import org.yeongtae.template.Templates;

/**
 * 회원 가입 컨트롤러
 *
 */

// JoinController 클래스: 회원 가입 요청을 처리하는 컨트롤러입니다. 사용자의 입력 정보를 받아 유효성 검사 후 데이터베이스에 저장하는 역할을 합니다.
public class JoinController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.JOIN);
    }
 
    @Override
    public void prompt() {
        String userId = promptWithValidation("아이디(6자리 이상): ", s -> s.length() >= 6);

        String userPw = promptWithValidation("비밀번호(8자리 이상): ", s -> s.length() >= 8);

        String confirmPw = promptWithValidation("비밀번호 확인: ", s -> {
           boolean match = s.equals(userPw);
           if (!match) {
               System.err.println("\n비밀번호가 일치하지 않습니다.");
           }

           return match;
        });

        String userNm = promptWithValidation("회원명: ", s -> !s.isBlank());

        RequestJoin form = RequestJoin.builder()
                .userId(userId)
                .userPw(userPw)
                .confirmPw(confirmPw)
                .userNm(userNm)
                .build();

        Router router = MainRouter.getInstance();
        try {
            // 회원 가입 처리...
            Service service = MemberServiceLocator.getInstance().find(MainMenu.JOIN);
            service.process(form);

            // 회원 가입 성공시 -> 로그인화면 이동
            router.change(MainMenu.LOGIN);
        } catch (RuntimeException e) {
            // 회원가입 실패시 -> 회원가입 화면으로 이동
            System.err.println(e.getMessage());
            router.change(MainMenu.JOIN);
        }
    }
}
