package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    /**
     * 数据源的手动创建
     * @throws SQLException
     */
    @Test
    public void test1() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///travel");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        DruidPooledConnection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    /**
     * 数据源的手动创建(读取jdbc.properties文件)
     * @throws SQLException
     */
    @Test
    public void test2() throws SQLException {
        //加载类路径下的jdbc.properties文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(rb.getString("jdbc.driverClass"));
        dataSource.setUrl(rb.getString("jdbc.url"));
        dataSource.setUsername(rb.getString("jdbc.username"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        DruidPooledConnection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    /**
     * Spring配置数据源
     * @throws SQLException
     */
    @Test
    public void test3() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSources = (DataSource) ac.getBean("dataSource");
        Connection con = dataSources.getConnection();
        System.out.println(con);
    }

    /**
     * Spring配置数据源(抽取jdbc.properties文件)
     * @throws SQLException
     */
    @Test
    public void test4() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSources = (DataSource) ac.getBean("dataSource");
        Connection con = dataSources.getConnection();
        System.out.println(con);
    }
}
