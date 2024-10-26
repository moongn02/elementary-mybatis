package cn.moongn.mybatis.binding;

import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;

import java.util.*;
import cn.hutool.core.lang.ClassScanner;

/**
 *
 * @author moongn
 * @description 映射器注册机
 * @date 2024/10/24
 *
 */

public class MapperRegistry {

    private Configuration configuration;

    public MapperRegistry(Configuration config) {
        this.configuration = config;
    }

    /**
     * 将已添加的映射器代理加入到 HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if(mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + "is no known to the MapperRegistry.");
        }
        try{
            return  mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        /* Mapper必须是接口才会注册 */
        if (type.isInterface()) {
            if(hasMapper(type)) {
                throw new RuntimeException("Type " + type +" is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return  knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperset = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperset) {
            addMapper(mapperClass);
        }
    }
}
