package main;

import java.sql.*;

class SqlSrvDBConn {
    private Statement stmt;
    private Connection conn;
    private ResultSet rs;

    SqlSrvDBConn() {
        stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=assn", "assn", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        rs = null;
    }

    Connection getConn() {
        return this.conn;
    }

    ResultSet executeQuery(String sql) {
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Data.executeQuery:" + e.getMessage());
        }
        return rs;
    }

    void closeStmt() {
        try {
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Data.executeQuery:" + e.getMessage());
        }
    }

    void closeConn() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Data.executeQuery:" + e.getMessage());
        }
    }
}
