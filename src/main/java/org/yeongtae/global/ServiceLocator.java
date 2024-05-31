package org.yeongtae.global;

import org.yeongtae.global.constants.MainMenu;

public interface ServiceLocator {
    Service find(MainMenu mainMenu);
}
