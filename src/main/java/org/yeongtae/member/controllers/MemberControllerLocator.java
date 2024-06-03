package org.yeongtae.member.controllers;

import org.yeongtae.global.Controller;
import org.yeongtae.global.ControllerLocator;
import org.yeongtae.global.constants.MainMenu;

import java.util.HashMap;
import java.util.Map;

// MemberControllerLocator 클래스: 요청에 따른 적절한 컨트롤러를 찾아 반환하는 클래스입니다.
public class MemberControllerLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<MainMenu, Controller> controllers;

    private MemberControllerLocator() {
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new MemberControllerLocator();
        }

        return instance;
    }


    @Override
    public Controller find(MainMenu mainMenu) {
        Controller controller = controllers.get(mainMenu);
        if (controller != null) {
            return controller;
        }

        switch(mainMenu) {
            case JOIN: controller = new JoinController(); break;
            default: controller = new LoginController();
        }

        controllers.put(mainMenu, controller);

        return controller;
    }
}
