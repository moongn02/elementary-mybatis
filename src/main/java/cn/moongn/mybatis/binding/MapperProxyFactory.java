package cn.moongn.mybatis.binding;

import cn.moongn.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author moongn
 * @description 映射器代理工厂
 * @date 2024/10/24
 *
 */

public class MapperProxyFactory <T> {
    private final Class<T> mapperInterface;

    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<Method, MapperMethod>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface, methodCache);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
