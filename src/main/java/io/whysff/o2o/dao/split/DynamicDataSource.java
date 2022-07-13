package io.whysff.o2o.dao.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/13
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDbType();
    }
}
