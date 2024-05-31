package org.yeongtae.global;

import org.yeongtae.global.constants.MainMenu;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLocator implements ServiceLocator {
    protected static ServiceLocator instance;

    protected Map<MainMenu, Service> services;


    protected AbstractServiceLocator() {
        services = new HashMap<>();
    }
}
