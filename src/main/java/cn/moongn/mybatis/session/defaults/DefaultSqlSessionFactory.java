package cn.moongn.mybatis.session.defaults;

import cn.moongn.mybatis.binding.MapperRegistry;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;
import cn.moongn.mybatis.session.SqlSessionFactory;

/**
 *
 * @author moongn
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2024/10/24
 *
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
