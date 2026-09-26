package com.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Conexi?n configurada fuera del c?digo y del historial de Git. */
public class Conexion {
    public static Connection getConexion() throws SQLException {
        String url = System.getenv("APP_DB_URL");
        String user = System.getenv("APP_DB_USER");
        String password = System.getenv("APP_DB_PASSWORD");
        if (url == null || url.trim().isEmpty() || user == null || user.trim().isEmpty()
                || password == null || password.isEmpty()) {
            throw new SQLException("Configure APP_DB_URL, APP_DB_USER y APP_DB_PASSWORD");
        }
        return DriverManager.getConnection(url, user, password);
    }
}
