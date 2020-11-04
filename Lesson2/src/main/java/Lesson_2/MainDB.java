package Lesson_2;


import java.sql.SQLException;

public class MainDB {

    public static void main(String[] args) {
        DbWorker sqlLite = new DbWorker();
        CRUD crud = new CRUD(sqlLite);

        try {
            System.out.println("Connect to DB..");
            sqlLite.connect();
            System.out.println("Connections is successfully!");

            System.out.println();

            crud.deleteTable("students");
            crud.createTable("students");

            System.out.println("Table is created");
            System.out.println();
            System.out.println("Create records:");

            crud.create("Anton", 1000);
            crud.create("Ivan", 2000);
            crud.readAll();

            crud.deleteById(2);

            System.out.println();
            System.out.println("One record is deleted");
            System.out.println();
            System.out.println("Records after delete:");

            crud.readAll();

            System.out.println();
            System.out.println("Read from file and update");

            crud.updateFromFile("test.txt");

            System.out.println();
            System.out.println("Table after updating:");

            crud.readAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            sqlLite.disconnect();
        }
    }
}