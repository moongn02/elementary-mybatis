package cn.moongn.mybatis.datasource.druid;

import cn.moongn.mybatis.datasource.DataSourceFactory;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.util.Properties;


/**
 *
 * @author moongn
 * @description 数据源工厂（阿里巴巴Druid）
 * @date 2024/10/31
 *
 */

public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        return dataSource;
    }
}
