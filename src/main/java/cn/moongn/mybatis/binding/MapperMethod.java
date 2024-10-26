package cn.moongn.mybatis.binding;

import cn.moongn.mybatis.mapping.MappedStatement;
import cn.moongn.mybatis.mapping.SqlCommandType;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;

import java.lang.reflect.Method;

/**
 *
 * @author moongn
 * @description 映射器方法
 * @date 2024/10/27
 *
 */

public class MapperMethod {

    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration)
    {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args)
    {
        Object result = null;
        switch (command.getType())
        {
            case INSERT:
                break;
            case DELETE:
                break;
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());
        }
        return result;
    }

    /**
     * SQL 指令
     */
    public static class SqlCommand{
        private final String name;
        private final SqlCommandType type;

        public SqlCommand(Configuration config, Class<?> mapperInterface, Method method)
        {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = config.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }

        public String getName()
        {
            return name;
        }

        public SqlCommandType getType()
        {
            return type;
        }
    }
}
