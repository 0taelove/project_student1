package org.yeongtae.global.validators;

// Validator 인터페이스는 유효성 검사를 수행하는 메서드를 정의합니다.
public interface Validator<T> {
    void check(T form);
}
