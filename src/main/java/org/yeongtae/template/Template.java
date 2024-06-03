package org.yeongtae.template;

// Template 인터페이스: 이 인터페이스는 모든 템플릿 클래스가 구현해야 하는 getTpl 메서드를 정의합니다. getTpl 메서드는 템플릿의 내용을 문자열로 반환합니다.
public interface Template {
    String getTpl();
}
