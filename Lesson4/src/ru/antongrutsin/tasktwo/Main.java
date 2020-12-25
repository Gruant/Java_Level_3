package ru.antongrutsin.tasktwo;

import java.util.LinkedList;
import java.util.List;

/*
Создать MFU c функциями, сканирования, печати и ксерокопирования
 */
public class Main {
    public static final List<Thread> queueList= new LinkedList<>();

    public static void main(String[] args) {
        MFU mfu = new MFU();

        for (int j = 1; j < 10; j++) {
            new Thread(new Customer(mfu, String.valueOf(j)), String.valueOf(j)).start();
        }
    }
}
