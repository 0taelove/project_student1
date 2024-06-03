package org.yeongtae;

import org.yeongtae.main.MainRouter;

// MainRouter.getInstance().start(); : MainRouter 클래스의 getInstance 메서드를 호출하여 MainRouter의 인스턴스를 얻고, 그 인스턴스의 start 메서드를 호출합니다.
public class Application {
    public static void main(String[] args) {
        MainRouter.getInstance().start();
    }
}
