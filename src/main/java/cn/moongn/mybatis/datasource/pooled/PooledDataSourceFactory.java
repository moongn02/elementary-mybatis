package cn.moongn.mybatis.datasource.pooled;

import cn.moongn.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 *
 * @author moongn
 * @description 有连接池的数据源工厂
 * @date 2024/11/1
 *
 */

public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public DataSource getDataSource() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(props.getProperty("driver"));
        pooledDataSource.setUrl(props.getProperty("url"));
        pooledDataSource.setUsername(props.getProperty("username"));
        pooledDataSource.setPassword(props.getProperty("password"));
        return pooledDataSource;
    }

}
