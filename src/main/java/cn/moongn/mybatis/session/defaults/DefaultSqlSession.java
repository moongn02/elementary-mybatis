package cn.moongn.mybatis.session.defaults;

import cn.moongn.mybatis.executor.Executor;
import cn.moongn.mybatis.mapping.MappedStatement;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;

import java.util.List;

/**
 *
 * @author moongn
 * @description 默认SqlSession实现类
 * @date 2024/11/26
 *
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        List<T> list = executor.query(mappedStatement, parameter, Executor.NO_RESULT_HANDLER, mappedStatement.getBoundSql());
        return list.get(0);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

}
