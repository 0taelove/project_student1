package org.yeongtae.template.main;

import org.yeongtae.member.MemberSession;
import org.yeongtae.member.entities.Member;
import org.yeongtae.template.Template;

// MainTpl 클래스: 이 클래스는 메인 메뉴를 생성하는 클래스입니다. 사용자가 로그인했는지 여부에 따라 다른 메뉴를 표시합니다. 로그인한 사용자에게는 학생 관리, 출결 관리, 성적 관리, 로그아웃 메뉴를 보여주고, 아직 로그인하지 않은 사용자에게는 회원가입 및 로그인 메뉴를 보여줍니다.
public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("메뉴를 선택하세요.\n");
        if (MemberSession.isLogin()) {
            Member member = MemberSession.getMember();
            sb.append(String.format("%s(%s)님 로그인\n", member.getUserNm(), member.getUserId()));
            sb.append("1. 학생관리\n");
            sb.append("2. 출결관리\n");
            sb.append("3. 성적관리\n");
            sb.append("4. 로그아웃\n");
        } else {
            sb.append("1. 회원가입\n");
            sb.append("2. 로그인\n");
        }
        sb.append("--------------------------------\n");

        return sb.toString();
    }
}
