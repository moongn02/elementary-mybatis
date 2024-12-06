package cn.moongn.mybatis.reflection;

import cn.moongn.mybatis.reflection.factory.DefaultObjectFactory;
import cn.moongn.mybatis.reflection.factory.ObjectFactory;
import cn.moongn.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import cn.moongn.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 *
 * @author moongn
 * @description 一些系统级别的元对象
 * @date 2024/12/5
 *
 */

public class SystemMetaObject {

    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

    private SystemMetaObject() {
        // Prevent Instantiation of Static Class
    }

    /**
     * 空对象
     */
    private static class NullObject {
    }

    public static MetaObject forObject(Object object) {
        return MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
    }

}
