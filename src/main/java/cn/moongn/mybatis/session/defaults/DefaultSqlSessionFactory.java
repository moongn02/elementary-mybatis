package cn.moongn.mybatis.session.defaults;

import cn.moongn.mybatis.executor.Executor;
import cn.moongn.mybatis.mapping.Environment;
import cn.moongn.mybatis.session.Configuration;
import cn.moongn.mybatis.session.SqlSession;
import cn.moongn.mybatis.session.SqlSessionFactory;
import cn.moongn.mybatis.session.TransactionIsolationLevel;
import cn.moongn.mybatis.transaction.Transaction;
import cn.moongn.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 *
 * @author moongn
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2024/11/26
 *
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction transaction = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            transaction = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(transaction);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert  transaction != null;
                transaction.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
