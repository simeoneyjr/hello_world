package com.enn.Singleton;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * 本类功能是：mybatis使用
 * Created by chao on 2016/7/27.
 */
    public class MybatisHelper {
    private final String sourcePath = "mybatis-config.xml";
    SqlSessionFactory sqlSessionFactory;

    public MybatisHelper() {
        try {
            Reader reader = Resources.getResourceAsReader(sourcePath);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 内部单例类
     */
    public static class MybatisSingleton {
        public static MybatisHelper mybatisHelper = new MybatisHelper();
    }

    /**
     * 获取mybatis单例类的SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        return MybatisSingleton.mybatisHelper.sqlSessionFactory;
    }

    /**
     * 获取单例类的session
     * @return
     */
    public static SqlSession getSession() {
        return getSqlSessionFactory().openSession();
    }

    /**
     * 指定是否自动提交来获取单例类的session
     * @param autoCommit
     * @return
     */
    public static SqlSession getSession(boolean autoCommit) {
        return getSqlSessionFactory().openSession(autoCommit);
    }

}
