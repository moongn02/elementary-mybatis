package cn.moongn.mybatis.transaction.jdbc;

import cn.moongn.mybatis.transaction.Transaction;
import cn.moongn.mybatis.transaction.TransactionFactory;
import cn.moongn.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 *
 * @author moongn
 * @description JdbcTransaction 工厂
 * @date 2024/10/31
 *
 */

public class JdbcTransactionFactory implements TransactionFactory {

    public Transaction newTransaction(Connection connection)
    {
        return new JdbcTransaction(connection);
    }

    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit)
    {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
