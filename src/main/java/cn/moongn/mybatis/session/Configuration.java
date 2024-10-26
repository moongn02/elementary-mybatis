package cn.moongn.mybatis.session;

import cn.moongn.mybatis.binding.MapperRegistry;
import cn.moongn.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moongn
 * @description 配置类 (包装注册机和SQL语句)
 * @date 2024/10/27
 */


public class Configuration {
    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }
    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}
