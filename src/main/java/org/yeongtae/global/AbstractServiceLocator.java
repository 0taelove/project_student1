package org.yeongtae.global;

import org.yeongtae.global.constants.MainMenu;

import java.util.HashMap;
import java.util.Map;

// AbstractServiceLocator 클래스는 서비스를 관리하는 역할을 합니다.
public abstract class AbstractServiceLocator implements ServiceLocator {
    protected static ServiceLocator instance;

    protected Map<MainMenu, Service> services;


    protected AbstractServiceLocator() {
        services = new HashMap<>();
    }
}
