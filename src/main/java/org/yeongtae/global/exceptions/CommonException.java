package org.yeongtae.global.exceptions;

import lombok.Getter;

// CommonException 클래스는 사용자 정의 예외를 처리합니다.
// 에러 메시지와 에러 코드를 가진다.
@Getter
public class CommonException extends RuntimeException {
    private int code; // 에러 코드

    public CommonException(String message, int code) {
        super(message);
        this.code = code;
    }
}
