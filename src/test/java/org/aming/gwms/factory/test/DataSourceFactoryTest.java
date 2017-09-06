package org.aming.gwms.factory.test;


import org.aming.gwms.factory.DataSourceFactory;

import org.junit.*;

import javax.sql.DataSource;

public class DataSourceFactoryTest {

    @Test
    public void testGetDataSource(){
        DataSource dataSource = DataSourceFactory.getDataSource();
        System.out.println(dataSource);
    }
}
