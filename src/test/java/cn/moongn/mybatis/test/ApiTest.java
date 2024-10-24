package cn.moongn.mybatis.test;

import cn.moongn.mybatis.binding.MapperProxyFactory;
import cn.moongn.mybatis.binding.MapperRegistry;
import cn.moongn.mybatis.session.SqlSession;
import cn.moongn.mybatis.session.SqlSessionFactory;
import cn.moongn.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.moongn.mybatis.test.dao.ISchoolDao;
import cn.moongn.mybatis.test.dao.IUserDao;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.*;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    //第一章：创建简单的映射器代理工厂
    /*
    @Test
    public void test_proxy_class(){
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                (((proxy, method, args) -> "你被代理了！"))
        );
        String result =  userDao.queryUserName("1");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }

    @Test
    public void test_MapperProxyFactory(){
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("cn.moongn.mybatis.test.dao.IUserDao.queryUserName", "模拟执行Mapper.xml中的SQL语句，操作：查询用户名称");

        IUserDao userDao = factory.newInstance(sqlSession);
        String result =  userDao.queryUserName("1");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }*/

    //第二章：实现映射器的注册和使用
    @Test
    public void test_MapperProxyFactory1(){
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.moongn.mybatis.test.dao");
        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 4. 测试验证
        String res = userDao.queryUserName("moongn..");
        logger.info("测试结果：{}", res);
    }
}
