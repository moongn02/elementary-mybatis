package cn.moongn.mybatis.session.defaults;

import cn.moongn.mybatis.mapping.MappedStatement;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;


/**
 *
 * @author moongn
 * @description 默认SqlSession实现类
 * @date 2024/10/27
 *
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理!" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
}
