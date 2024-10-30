package cn.moongn.mybatis.mapping;

import java.util.Map;

/**
 *
 * @author moongn
 * @description 绑定的SQL,是从SqlSource而来，将动态内容都处理完成得到的SQL语句字符串，其中包括?,还有绑定的参数
 * @date 2024/10/31
 *
 */

public class BoundSql {

    private String sql;
    private Map<Integer, String> parameterMappings;
    private String parameterType;
    private String resultType;

    public BoundSql(String sql, Map<Integer, String> parameterMappings, String parameterType, String resultType) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.parameterType = parameterType;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public Map<Integer, String> getParameterMappings() {
        return parameterMappings;
    }

    public void setParameterMappings(Map<Integer, String> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}
