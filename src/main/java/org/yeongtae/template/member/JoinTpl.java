package org.yeongtae.template.member;

import org.yeongtae.template.Template;
import org.yeongtae.template.Templates;

// JoinTpl 클래스: 이 클래스는 회원가입 화면을 생성하는 클래스입니다. 화면에 "회원가입" 및 "다음 가입 항목을 입력하세요."라는 메시지와 함께 입력할 가입 항목을 표시합니다.
public class JoinTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("회원가입\n");
        sb.append("다음 가입 항목을 입력하세요.\n");
        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
