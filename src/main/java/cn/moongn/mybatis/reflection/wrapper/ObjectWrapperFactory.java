package cn.moongn.mybatis.reflection.wrapper;

import cn.moongn.mybatis.reflection.MetaObject;

/**
 *
 * @author moongn
 * @description 对象包装工厂
 * @date 2024/12/4
 *
 */

public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
