package ru.antongrutsin;

import java.io.*;
//Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
public class TaskOne {

    private static final String FILEPATH = "";

    public static void main(String[] args) {
        try(FileInputStream reader = new FileInputStream(FILEPATH)){
            byte[] buffer = new byte[reader.available()];
            reader.read(buffer);

            for (byte b : buffer) {
                System.out.print("" + b + " ");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
