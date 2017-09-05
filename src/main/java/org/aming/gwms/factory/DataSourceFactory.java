package org.aming.gwms.factory;

import javax.sql.DataSource;

import org.aming.gwms.exceptions.Exceptions;
import org.aming.gwms.utils.PropertyLoader;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

public class DataSourceFactory {
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        try {
            if (dataSource == null) {
                synchronized (DataSourceFactory.class) {
                    if (dataSource == null) {
                        dataSource = newDataSource();
                    }
                }
            }
            return dataSource;
        } catch (Exception ex) {
            throw Exceptions.toRuntimeException(ex);
        }

    }

    private static DataSource newDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        PropertyLoader propertyLoader = PropertyLoader.getInstance("/jdbc.properties");
        dataSource.setDriverClass(propertyLoader.getProperty("driver"));
        dataSource.setJdbcUrl(propertyLoader.getProperty("jdbcUrl"));
        dataSource.setUser(propertyLoader.getProperty("user"));
        dataSource.setPassword(propertyLoader.getProperty("password"));
        return dataSource;
    }
}
