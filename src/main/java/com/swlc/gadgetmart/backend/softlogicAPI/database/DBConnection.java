package com.swlc.gadgetmart.backend.softlogicAPI.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;


public class DBConnection {

    private static DBConnection dbConnection;
    private final BasicDataSource ds;

    private DBConnection() {
        ds = new BasicDataSource();
        ds.setDriverClassName(DBConfiguration.DRIVER);
        ds.setUsername(DBConfiguration.USERNAME);
        ds.setPassword(DBConfiguration.PASSWORD);
        ds.setUrl(DBConfiguration.DB_URL);

    }

    public static synchronized DBConnection getDBConnection() throws Exception {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
            return dbConnection;
        } else {
            return dbConnection;
        }
    }

    public Connection getConnection() throws Exception {
        return this.ds.getConnection();
    }
}
