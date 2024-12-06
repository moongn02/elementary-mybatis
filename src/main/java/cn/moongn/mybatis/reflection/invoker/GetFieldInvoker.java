package cn.moongn.mybatis.reflection.invoker;

import java.lang.reflect.Field;

/**
 *
 * @author moongn
 * @description getter 调用者
 * @date 2024/12/5
 *
 */

public class GetFieldInvoker implements Invoker {

    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }

}
