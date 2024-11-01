package cn.moongn.mybatis.session;

import cn.moongn.mybatis.datasource.pooled.PooledDataSourceFactory;
import cn.moongn.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import cn.moongn.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.moongn.mybatis.binding.MapperRegistry;
import cn.moongn.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.moongn.mybatis.mapping.Environment;
import cn.moongn.mybatis.mapping.MappedStatement;
import cn.moongn.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author moongn
 * @description 配置类
 * @date 2024/10/31
 */


public class Configuration {

    // 环境
    protected Environment environment;

     // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

     // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);

    }

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

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

}
