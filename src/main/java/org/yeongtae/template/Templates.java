package org.yeongtae.template;

import org.yeongtae.global.constants.MainMenu;
import org.yeongtae.template.main.MainTpl;
import org.yeongtae.template.member.JoinTpl;
import org.yeongtae.template.member.LoginTpl;

import java.util.HashMap;
import java.util.Map;

// Templates 클래스: 이 클래스는 싱글톤 패턴을 사용하여 클래스의 인스턴스를 한 개만 생성하도록 합니다. 이 클래스는 다양한 템플릿을 관리하고, 각 템플릿을 찾거나 렌더링하는 메서드를 포함하고 있습니다.
public class Templates {
    private static Templates instance;
    private Map<MainMenu, Template> tpls;

    private Templates() {
        tpls = new HashMap<>();
    }

    public static Templates getInstance() {
        if (instance == null) {
            instance = new Templates();
        }

        return instance;
    }

    public void render(MainMenu mainMenu) {

        System.out.println(find(mainMenu).getTpl());
    }

    public Template find(MainMenu mainMenu) {
        Template tpl = tpls.get(mainMenu);
        if (tpl != null) {
            return tpl;
        }

        switch (mainMenu) {
            case JOIN: tpl = new JoinTpl(); break;
            case LOGIN: tpl = new LoginTpl(); break;
            default: tpl = new MainTpl();
        }

        tpls.put(mainMenu, tpl);

        return tpl;
    }

    public String line() {
        return "-----------------------------------\n";
    }

    public String doubleLine() {
        return "===================================\n";
    }
}
