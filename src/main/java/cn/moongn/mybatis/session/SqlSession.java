package cn.moongn.mybatis.session;

/**
 *
 * @author moongn
 * @description SqlSession 用来执行SQL，获取映射器，管理事务。
 * @date 2024/11/26
 *
 */

public interface SqlSession {

    /**
     * Retrieves current configuration
     * 得到配置
     * @return Configuration
     */
    Configuration getConfiguration();

    /**
     * Retrieve a single row mapped from the statement key
     * 根据指定的SqlID获取一条记录的封装对象
     *
     * @param <T>           the returned object type 封装之后的对象类型
     * @param statement     sqlID
     * @return Mapped       object 封装之后的对象
     */
    <T> T selectOne(String statement);

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
     * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
     *
     * @param <T>       the returned object type                            封装之后的对象类型
     * @param statement Unique identifier matching the statement to use.    sqlID
     * @param parameter A parameter object to pass to the statement.        参数对象
     * @return Mapped object
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * Retrieves a mapper.
     * 得到映射器，这个巧妙的使用泛型，使得类型安全
     *
     * @param <T>  the mapper type
     * @param type Mapper interface class
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);
}
