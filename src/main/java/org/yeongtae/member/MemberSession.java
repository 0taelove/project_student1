package org.yeongtae.member;

import org.yeongtae.member.entities.Member;

// MemberSession 클래스: 로그인한 사용자의 정보를 세션에 저장하고 관리하는 클래스입니다.
public class MemberSession {
    private static Member member;

    /**
     * 로그인은 회원 정보를 애플리케이션 전역에 유지하면 되므로
     * DB에서 조회된 member를 정적 변수 member에 할당
     * @param member
     */
    public static void login(Member member) {
        MemberSession.member = member;
    }

    /**
     * 로그인 여부 체크
     * 정적 변수인 member에 회원 정보가 유지되고 있으면 로그인 상태이다.
     * @return
     */
    public static boolean isLogin() {
        return member != null;
    }

    /**
     * 로그아웃은 정적 변수인 member의 값을 비워 주면 된다.
     *
     */
    public static void logout() {
        member = null;
    }

    public static Member getMember() {
        return member;
    }
}
