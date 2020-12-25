package Lesson_2;

import java.sql.*;

public class DbWorker {
    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement pstmt;

    protected void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = conn.createStatement();
    }

    protected void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
