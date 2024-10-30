package cn.moongn.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author moongn
 * @description 事务接口
 * @date 2024/10/31
 *
 */

public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}
