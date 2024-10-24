package cn.moongn.mybatis.binding;

import cn.moongn.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 *
 * @author moongn
 * @description 映射器代理工厂
 * @date 2024/10/24
 *
 */

public class MapperProxyFactory <T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
