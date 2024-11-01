package cn.moongn.mybatis.test;

import cn.moongn.mybatis.binding.MapperProxyFactory;
import cn.moongn.mybatis.binding.MapperRegistry;
import cn.moongn.mybatis.builder.xml.XMLConfigBuilder;
import cn.moongn.mybatis.datasource.pooled.PooledDataSource;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;
import cn.moongn.mybatis.session.SqlSessionFactory;
import cn.moongn.mybatis.session.SqlSessionFactoryBuilder;
import cn.moongn.mybatis.session.defaults.DefaultSqlSession;
import cn.moongn.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.moongn.mybatis.test.dao.ISchoolDao;
import cn.moongn.mybatis.test.dao.IUserDao;
import cn.moongn.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import cn.moongn.mybatis.io.Resources;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
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
    /*@Test
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
    }*/

    //第三章：Mapper XML的解析和注册使用
    /*@Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取Session
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}",res);
    }*/

    //第四章：数据源的解析、创建和使用
    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

    @Test
    public void test_selectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("cn.moongn.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

    // 第五章：数据源池化技术实现
    @Test
    public void testSqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            logger.info("测试结果：{}", JSON.toJSONString(user));
        }
    }

    @Test
    public void test_pooled() throws SQLException, InterruptedException {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://127.0.0.1:3309/hdmybatis?useUnicode=true");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("123456");
        // 持续获得链接
        while (true){
            Connection connection = pooledDataSource.getConnection();
            System.out.println(connection);
            Thread.sleep(1000);
            // 链接关闭，一直开启的是同一个链接；反之，循环开启的是不同的链接，在活跃链接数量达到上限后，会休眠一段时间，直到有空闲链接
            connection.close();
        }
    }

}
