package org.yeongtae.main;

import org.yeongtae.global.*;
import org.yeongtae.global.constants.MainMenu;
import org.yeongtae.main.controllers.MainController;
import org.yeongtae.member.controllers.MemberControllerLocator;

// MainRouter 클래스는 라우터와 시작 가능한 인터페이스를 구현합니다. 이 클래스는 싱글톤 패턴을 사용하여 인스턴스를 생성합니다.
// change() 메서드는 주어진 메뉴에 따라 다른 컨트롤러로 변경합니다. JOIN과 LOGIN 메뉴에 대해 MemberControllerLocator에서 해당 컨트롤러를 찾고, 그 외의 경우 MainController를 사용합니다.
// start() 메서드는 메인 컨트롤러 출력 화면을 첫 화면으로 사용하여 무한 루프를 실행합니다.
public class MainRouter implements Router, Startable {

    private static MainRouter instance;

    private MainRouter() {}

    public static MainRouter getInstance() {
        if (instance == null) {
            instance = new MainRouter();
        }

        return instance;
    }

    @Override
    public void change(Menu menu) {
        ControllerLocator memlocator = MemberControllerLocator.getInstance();

        Controller controller = null;
        MainMenu mainMenu = (MainMenu) menu;
        switch(mainMenu) {
            case JOIN: controller =  memlocator.find(MainMenu.JOIN); break;
            case LOGIN: controller = memlocator.find(MainMenu.LOGIN); break;
            default: controller = new MainController();
        }

        controller.run(); // common(), show(), prompt()
    }

    @Override
    public void start() {
        while(true) {
            change(MainMenu.MAIN); // 첫 화면은 메인 컨트롤러 출력 화면
        }
    }
}