package ru.antongrutsin.tasktwo;

import java.io.InputStream;

public class MFU {
    private final Object print = new Object();
    private final Object scanner = new Object();
    private final Object photocopier = new Object();

    public void printer() {
        Thread thread = Thread.currentThread();
        synchronized (print){
            System.out.println("Документ пользователя №" + thread.getName() + " печатается");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void scannerForPrint() {
        Thread thread = Thread.currentThread();
        synchronized (print){
            synchronized (scanner){
                    System.out.println("Документ пользователя №" + thread.getName() + "сканируется и " +
                            "печатается");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void photocopierToPrint(){
        Thread thread = Thread.currentThread();
        synchronized (print){
                synchronized (photocopier){

                    System.out.println("Документ пользователя №" + thread.getName() + " копируется и печатается");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void photocopierToEmail(){
        Thread thread = Thread.currentThread();
        synchronized (photocopier){
                System.out.println("Документ пользователя №" + thread.getName() + " копируется и отправляется по Email");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void scannerToEmail(){
        Thread thread = Thread.currentThread();
        synchronized (scanner){
            System.out.println("Документ пользователя №" + thread.getName() + " сканируется и отправляется по Email");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
