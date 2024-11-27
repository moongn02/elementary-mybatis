package cn.moongn.mybatis.executor;

import cn.moongn.mybatis.executor.statement.StatementHandler;
import cn.moongn.mybatis.mapping.BoundSql;
import cn.moongn.mybatis.mapping.MappedStatement;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.ResultHandler;
import cn.moongn.mybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author moongn
 * @description 简单执行器
 * @date 2024/11/26
 *
 */

public class SimpleExecutor  extends BaseExecutor{

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try{
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler = configuration.newStatementHandler(this, ms, parameter, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            Statement statement = handler.prepare(connection);
            handler.parameterize(statement);
            return handler.query(statement, resultHandler);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
