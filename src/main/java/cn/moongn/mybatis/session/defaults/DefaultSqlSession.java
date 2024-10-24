package cn.moongn.mybatis.session.defaults;

import cn.moongn.mybatis.binding.MapperRegistry;
import cn.moongn.mybatis.session.SqlSession;

/**
 *
 * @author moongn
 * @description 默认SqlSession实现类
 * @date 2024/10/24
 *
 */

public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理啦~" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理啦~" + "方法：" + statement + "入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
