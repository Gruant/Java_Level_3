package ru.antongrutsin.Lesson5.Serializator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3345)) {
            Socket client = server.accept();
            System.out.println("Соединение принято");

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            System.out.println("Десеарилизированные данные:");
            System.out.println((Model)in.readObject());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

