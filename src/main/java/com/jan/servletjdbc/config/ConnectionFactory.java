package com.jan.servletjdbc.config;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private final static String DB_NAME = "jdbc-servlet";
    private final static String URL = "jdbc:mysql://localhost/" + DB_NAME + "?autoReconnect=true&useSSL=false";
    private final static String USER = "root";
    private final static String PASSWORD = "root";

    private static Connection connection;
    private DataSource dataSource;

    public ConnectionFactory() {
        MysqlConnectionPoolDataSource pool = new MysqlConnectionPoolDataSource();
        pool.setUrl(URL);
        pool.setUser(USER);
        pool.setPassword(PASSWORD);
        this.dataSource = pool;
    }


    public Connection getPoolConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public static void closeConnection() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}
