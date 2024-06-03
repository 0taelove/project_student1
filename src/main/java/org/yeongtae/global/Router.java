package org.yeongtae.global;

/**
 * 사용자가 입력한 메뉴 번호, 문구 -> 해당하는 컨트롤러로 연결
 */

// Router 인터페이스는 사용자의 입력에 따라 적절한 컨트롤러로 연결하는 메서드를 정의합니다.
public interface Router {
    void change(Menu menu);
    // void start();
}
