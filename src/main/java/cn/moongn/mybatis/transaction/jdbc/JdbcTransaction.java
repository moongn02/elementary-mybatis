package cn.moongn.mybatis.transaction.jdbc;

import cn.moongn.mybatis.transaction.Transaction;
import cn.moongn.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author moongn
 * @description JDBC 事务，直接利用 JDBC 的 commit、rollback。依赖于数据源获得的连接来管理事务范围。
 * @date 2024/10/31
 *
 */

public class JdbcTransaction implements Transaction {
    protected Connection connection;
    protected DataSource dataSource;
    protected TransactionIsolationLevel level = TransactionIsolationLevel.NONE;
    protected boolean autoCommit;

    public JdbcTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit)
    {
        this.dataSource = dataSource;
        this.level = level;
        this.autoCommit = autoCommit;
    }

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setTransactionIsolation(level.getLevel());
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    public void commit() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.commit();
        }
    }

    public void rollback() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.rollback();
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.close();
        }
    }

}
