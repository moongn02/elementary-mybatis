package cn.moongn.mybatis.datasource.pooled;

import cn.moongn.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 *
 * @author moongn
 * @description 有连接池的数据源工厂
 * @date 2024/12/4
 *
 */

public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
