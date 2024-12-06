package cn.moongn.mybatis.reflection.invoker;

/**
 *
 * @author moongn
 * @description 调用者
 * @date 2024/12/5
 *
 */

public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
