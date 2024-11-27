package cn.moongn.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author moongn
 * @description 结果处理器
 * @date 2024/11/26
 *
 */

public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement statement) throws SQLException;

}
