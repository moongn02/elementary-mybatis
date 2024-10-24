package cn.moongn.mybatis.binding;

import cn.moongn.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 *
 * @author moongn
 * @description 映射器代理类
 * @date 2024/10/24
 *
*/

public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final Long serialVersionUID = -6424540398559729838L;

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this, args);
        }else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
