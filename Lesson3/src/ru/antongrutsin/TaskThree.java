package ru.antongrutsin;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Scanner;

/*
Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */
public class TaskThree {
    private static final int SYMBOLONPAGE = 1800;
    private static final String FILEPATH = "";

    public static void main(String[] args) {
        long timeOne = System.currentTimeMillis();

        System.out.println("Для выхода необходимо нажать 0");
        int pageNumber;
        Scanner sc = new Scanner(System.in);

        try (RandomAccessFile file = new RandomAccessFile(FILEPATH, "r")) {
            long deltaOne = System.currentTimeMillis() - timeOne;
            System.out.println("Время загрузки: " + deltaOne + " мс");
            System.out.println();
            int x;
            do {
                System.out.print("Введите страницу: ");
                pageNumber = sc.nextInt();
                if (pageNumber != 0) {
                    long timeTwo = System.currentTimeMillis();

                    for (int i = 0; i < SYMBOLONPAGE; i++) {
                        file.seek((pageNumber - 1) * SYMBOLONPAGE + i);
                        if((x = file.read()) != -1) {
                            System.out.print((char) x);
                        } else {
                            System.out.println("Конец файла");
                            break;
                        }
                    }

                    System.out.println();
                    long deltaTwo = System.currentTimeMillis() - timeTwo;
                    System.out.println("Время чтения " + deltaTwo + " мс");
                }
            } while (pageNumber != 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


