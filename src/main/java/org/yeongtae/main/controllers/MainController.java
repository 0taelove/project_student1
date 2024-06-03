package org.yeongtae.main.controllers;

import org.yeongtae.global.AbstractController;
import org.yeongtae.global.constants.MainMenu;
import org.yeongtae.template.Templates;

/**
 * 메인 컨트롤러
 *
 */

// MainController 클래스는 AbstractController 클래스를 확장하여 메인 컨트롤러를 생성합니다. show() 메서드를 오버라이드하여 메인 메뉴를 렌더링하는 기능을 구현합니다.
public class MainController extends AbstractController {
    @Override
    public void show() {


        Templates.getInstance().render(MainMenu.MAIN);
    }
}
