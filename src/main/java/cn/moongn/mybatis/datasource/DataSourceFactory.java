package cn.moongn.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 * @author moongn
 * @description 数据源工厂
 * @date 2024/10/31
 *
 */

public interface DataSourceFactory {

    void setProperties(Properties properties);

    DataSource getDataSource();
}
