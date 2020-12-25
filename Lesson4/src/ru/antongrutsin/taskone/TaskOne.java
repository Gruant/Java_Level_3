package ru.antongrutsin.taskone;

import sun.print.PrintJob2D;

/*
1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
(порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 */
public class TaskOne {
    static volatile char str = 'A';
    public static void main(String[] args) {
        Object lock = new Object();
        class MyTask implements Runnable {
            private char b;
            private char nextB;
            public MyTask(char b, char nextB) {
                this.b = b;
                this.nextB = nextB;
            }
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (str != b) {
                                lock.wait();
                            }
                            System.out.print(b);
                            str = nextB;
                            lock.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        new Thread(new MyTask('A', 'B')).start();
        new Thread(new MyTask('B', 'C')).start();
        new Thread(new MyTask('C', 'A')).start();
    }

}
