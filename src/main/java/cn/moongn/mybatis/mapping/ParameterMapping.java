package cn.moongn.mybatis.mapping;

import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.type.JdbcType;

/**
 *
 * @author moongn
 * @description 参数映射 #{property,javaType=int,jdbcType=NUMERIC}
 * @date 2024/10/31
 *
 */

public class ParameterMapping {

    private Configuration configuration;;

    // property
    private String property;
    // javaType = int
    private Class<?> javaType = Object.class;
    // jdbcType = NUMERIC
    private JdbcType jdbcType;

    public ParameterMapping()
    {

    }

    public static class Builder
    {
        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration, String property)
        {
            this.parameterMapping.configuration = configuration;
            this.parameterMapping.property = property;
        }

        public Builder javaType(Class<?> javaType)
        {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType)
        {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }

    }

    public Configuration getConfiguration()
    {
        return configuration;
    }

    public String getProperty()
    {
        return property;
    }

    public Class<?> getJavaType()
    {
        return javaType;
    }

    public JdbcType getJdbcType()
    {
        return jdbcType;
    }
}
