package cn.moongn.mybatis.executor.statement;

import cn.moongn.mybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author moongn
 * @description 语句处理器
 * @date 2024/11/26
 *
 */

public interface StatementHandler {

    // 准备语句
    Statement prepare(Connection connection) throws SQLException;
    // 参数化
    void parameterize(Statement statement) throws SQLException;
    // 执行查询
    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;
}
