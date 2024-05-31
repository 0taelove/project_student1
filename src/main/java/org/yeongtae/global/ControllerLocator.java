package org.yeongtae.global;

import org.yeongtae.global.constants.MainMenu;

public interface ControllerLocator {
    Controller find(MainMenu mainMenu);
}
