package cn.moongn.mybatis.session;

import java.sql.Connection;

/**
 *
 * @author moongn
 * @description 事务隔离级别
 * @date 2024/10/31
 *
 */

public enum TransactionIsolationLevel {

    // 包括JDB从支持的5个级别
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE),
    NONE(Connection.TRANSACTION_NONE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
