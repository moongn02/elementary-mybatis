package cn.moongn.mybatis.mapping;

/**
 *
 * @author moongn
 * @description 指令类型
 * @date 2024/10/27
 *
 */

public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
