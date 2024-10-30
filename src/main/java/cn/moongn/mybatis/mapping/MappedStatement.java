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
    private BoundSql boundSql;

    MappedStatement(){

    }

    /**
     * 建造者
     */
    public static class Builder{
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, BoundSql boundSql){
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            mappedStatement.boundSql = boundSql;
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

    public BoundSql getBoundSql() {
        return boundSql;
    }

    public void setBoundSql(BoundSql boundSql) {
        this.boundSql = boundSql;
    }
}
