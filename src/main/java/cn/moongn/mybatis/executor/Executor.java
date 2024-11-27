package cn.moongn.mybatis.executor;

import cn.moongn.mybatis.mapping.BoundSql;
import cn.moongn.mybatis.mapping.MappedStatement;
import cn.moongn.mybatis.session.ResultHandler;
import cn.moongn.mybatis.transaction.Transaction;

import java.util.List;

/**
 *
 * @author moongn
 * @description 执行器
 * @date 2024/11/26
 *
 */

public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws Exception;

    void rollback(boolean required) throws Exception;

    void close(boolean forceRollback);

}
