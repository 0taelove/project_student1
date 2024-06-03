package org.yeongtae.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

// DBConn 클래스는 마이바티스를 이용해 데이터베이스에 연결하는 역할을 합니다.
public class DBConn {
    private static SqlSessionFactory factory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("org/yeongtae/global/configs/mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    public static SqlSession getSession() {
        return getSession(true);
    }
}
