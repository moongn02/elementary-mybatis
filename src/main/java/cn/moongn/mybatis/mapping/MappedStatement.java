package cn.moongn.mybatis.mapping;

import cn.moongn.mybatis.session.Configuration;

import java.util.Map;

/**
 *
 * @author moongn
 * @description 映射语句类
 * @date 2024/10/27
 *
 */

public class MappedStatement {
    private Configuration configuration;
    private String id;
    private SqlCommandType sqlCommandType;

    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;

    MappedStatement(){

    }

    /**
     * 建造者
     */
    public static class Builder{
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, String parameterType, String resultType, String sql, Map<Integer, String> parameter){
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.sql = sql;
            mappedStatement.parameterType = parameterType;
            mappedStatement.resultType = resultType;
            mappedStatement.parameter = parameter;
        }

        public MappedStatement build(){
            assert mappedStatement.id != null;
            assert mappedStatement.configuration != null;
            return mappedStatement;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public void setSqlCommandType(SqlCommandType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParameter() {
        return parameter;
    }

    public void setParameter(Map<Integer, String> parameter) {
        this.parameter = parameter;
    }
}
