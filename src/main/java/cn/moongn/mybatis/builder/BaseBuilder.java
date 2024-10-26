package cn.moongn.mybatis.builder;

import cn.moongn.mybatis.session.Configuration;

/**
 *
 * @author moongn
 * @description 构建器的基类，建造者模式
 * @date 2024/10/27
 *
 */

public abstract class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
