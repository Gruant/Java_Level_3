package ru.antongrutsin.Lesson5.Serializator;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 3345);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());)
        {
            Model obj = new Model("Антон", 34, 'М');
            System.out.println("Подключились");
            System.out.println();

            System.out.println("Сериализируемый объект: " + obj);

            oos.writeObject(obj);
            oos.flush();

            } catch (IOException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
