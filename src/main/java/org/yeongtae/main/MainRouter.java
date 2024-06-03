package org.yeongtae.main;

import org.yeongtae.global.*;
import org.yeongtae.global.constants.MainMenu;
import org.yeongtae.main.controllers.MainController;
import org.yeongtae.member.controllers.MemberControllerLocator;

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