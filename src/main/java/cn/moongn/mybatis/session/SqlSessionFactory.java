package cn.moongn.mybatis.session;

/**
 *
 * @author moongn
 * @description 简单工厂模式，用于提供 SqlSession 服务
 * @date 2024/10/24
 *
 */

public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
