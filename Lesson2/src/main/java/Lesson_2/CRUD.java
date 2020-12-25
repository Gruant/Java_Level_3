package Lesson_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CRUD {
    private final DbWorker worker;

    public CRUD (DbWorker worker){
        this.worker = worker;
        try {
            this.worker.connect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String table) {
        try {
            worker.stmt.executeUpdate("CREATE TABLE " + table + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "score INT )" +
                    ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(String name, int score){
        try {
            worker.pstmt = worker.conn.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)");
            worker.pstmt.setString(1, name);
            worker.pstmt.setInt(2, score);
            worker.pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readByName(String name) {
        try{
            worker.pstmt = worker.conn.prepareStatement("SELECT * FROM students WHERE name = ?");
            worker.pstmt.setString(1, name);
            ResultSet rs = worker.pstmt.executeQuery();
            result(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readAll() {
        try{
            ResultSet rs = worker.stmt.executeQuery("SELECT * FROM students");
            result(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            worker.pstmt = worker.conn.prepareStatement("DELETE FROM students WHERE id = ?");
            worker.pstmt.setInt(1, id);
            worker.pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable(String table) {
        try {
            String stringSQL = String.format("DROP TABLE %s", table);
            worker.stmt.executeUpdate(stringSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFromFile (String filePath) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            this.worker.conn.setAutoCommit(false);
            while ((line = reader.readLine()) != null) {
                String[] valueArr = line.split(" ");
                create(valueArr[1], Integer.parseInt(valueArr[2]));
            }
            this.worker.conn.commit();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void result (ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t " + rs.getString("name") +
                    "\t " + rs.getInt("score"));
        }
    }
}
