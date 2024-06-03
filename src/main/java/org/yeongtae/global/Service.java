package org.yeongtae.global;

// Service 인터페이스는 특정 작업을 처리하는 메서드를 정의합니다.
public interface Service<T> {
    void process(T form);
}
