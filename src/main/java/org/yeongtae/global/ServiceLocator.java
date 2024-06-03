package org.yeongtae.global;

import org.yeongtae.global.constants.MainMenu;

// ServiceLocator 인터페이스는 주어진 메뉴에 대한 서비스를 찾는 메서드를 정의합니다.
public interface ServiceLocator {
    Service find(MainMenu mainMenu);
}
