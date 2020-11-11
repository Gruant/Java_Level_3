package ru.antongrutsin.taskone;

import sun.print.PrintJob2D;

/*
1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
(порядок – ABСABСABС). Используйте wait/notify/notifyAll.
 */
public class TaskOne {
    private volatile int flag = 1;

    public static void main(String[] args) {
        TaskOne obj = new TaskOne();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printA();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printB();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printC();
            }
        });

        t1.start();
        t2.start();
        t3.start();


    }

    synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while(flag!=1) {
                    wait();
                }
                System.out.print("A");
                setFlag(2);
                notifyAll();
            }
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
    }

    synchronized void printB(){
        try {
            for (int i = 0; i < 5; i++) {
                while(flag!=2) {
                    wait();
                }
                System.out.print("B");
                setFlag(3);
                notifyAll();
            }
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
    }

    synchronized void printC(){
        try {
            for (int i = 0; i < 5; i++) {
                while(flag!=3) {
                    wait();
                }
                System.out.print("C");
                setFlag(1);
                notifyAll();
            }
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
    }

    public void setFlag(int flag){
        this.flag = flag;
    }

}
