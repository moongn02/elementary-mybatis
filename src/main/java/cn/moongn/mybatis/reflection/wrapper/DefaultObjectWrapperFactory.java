package cn.moongn.mybatis.reflection.wrapper;

import cn.moongn.mybatis.reflection.MetaObject;

/**
 *
 * @author moongn
 * @description 默认对象包装工厂
 * @date 2024/12/6
 *
 */

public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }

}
