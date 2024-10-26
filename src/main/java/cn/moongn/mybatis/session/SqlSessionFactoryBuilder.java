package cn.moongn.mybatis.session;

import cn.moongn.mybatis.builder.xml.XMLConfigBuilder;
import cn.moongn.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 *
 * @author moongn
 * @description 构建SqlSessionFactory建造者工厂
 * @date 2024/10/27
 *
 */

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
