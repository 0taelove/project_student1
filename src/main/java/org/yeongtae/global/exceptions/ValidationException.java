package org.yeongtae.global.exceptions;

// ValidationException 클래스는 사용자 정의 예외를 처리합니다.
// 유효성 검사 실패 시 발생하는 예외를 처리합니다.
public class ValidationException extends CommonException{

    // 유효성 검사 실패 오류 코드는 400으로 정함
    public ValidationException(String message) {
        super(message, 400);
    }
}
