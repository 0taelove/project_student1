package org.yeongtae.global;

import org.yeongtae.global.constants.MainMenu;

// ControllerLocator 인터페이스는 주어진 메뉴에 대한 컨트롤러를 찾는 메서드를 정의합니다.
public interface ControllerLocator {
    Controller find(MainMenu mainMenu);
}
