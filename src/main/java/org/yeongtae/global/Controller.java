package org.yeongtae.global;

// Controller 인터페이스는 서비스와 뷰를 연결하고 실행하는 메서드를 정의합니다.
public interface Controller {
    void show(); // 서비스(Model)와 뷰를 연결
    void run();
}
