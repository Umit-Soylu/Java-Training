package com.bilgeadam.java.tutorials.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private final static String connectionType = "jdbc:mysql:";
    private final static String path = "//localhost:3306";
    private final static String schemaName = "/employees";
    private final static String userName ="umitsoylu";
    private final static String password = null;

    public Connection getConnection() throws SQLException {
        // This is the connection object used by JDBC
        return DriverManager.getConnection( connectionType + path + schemaName, userName, password);
    }
}
