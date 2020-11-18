package com.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource dataSource;
    static {
        Properties properties=new Properties();
        InputStream inputStream=JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try{
            properties.load(inputStream);
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        }catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection()throws SQLException{
        return dataSource.getConnection();
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException s){
                s.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            }catch (SQLException s){
                s.printStackTrace();
            }
        }if (connection != null){
            try {
                connection.close();
            }catch (SQLException s){
                s.printStackTrace();
            }
        }
    }

    public static void close(Connection connection,Statement statement){
        close(connection,statement);
    }
}
