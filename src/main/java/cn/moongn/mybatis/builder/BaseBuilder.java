package cn.moongn.mybatis.builder;

import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.type.TypeAliasRegistry;

/**
 *
 * @author moongn
 * @description 构建器的基类，建造者模式
 * @date 2024/10/31
 *
 */

public abstract class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
