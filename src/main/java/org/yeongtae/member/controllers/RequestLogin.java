package org.yeongtae.member.controllers;

import lombok.Builder;
import lombok.Data;

// RequestLogin 클래스: 회원 가입 및 로그인 요청에 대한 정보를 담는 Data Transfer Object(DTO)입니다.
@Data
@Builder
public class RequestLogin {
    private String userId;
    private String userPw;
}
