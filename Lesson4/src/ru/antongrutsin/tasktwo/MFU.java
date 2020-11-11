package ru.antongrutsin.tasktwo;

import java.io.InputStream;

public class MFU {
    private final Object print = new Object();
    private final Object scanner = new Object();
    private final Object photocopier = new Object();
    private volatile boolean scannerIsBusy = false;
    private volatile boolean printIsBusy = false;
    private volatile boolean photocopierIsBusy = false;

    public void printer() {
        Thread thread = Thread.currentThread();
        synchronized (print){
            try{
                while(printIsBusy){
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printIsBusy = true;
            System.out.println("Документ пользователя №" + thread.getName() + " печатается");
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            printIsBusy = false;
            print.notifyAll();
        }
    }

    public void scannerForPrint() {
        Thread thread = Thread.currentThread();
        synchronized (print){
            try{
                while(printIsBusy){
                    wait();
                }
                printIsBusy = true;
                synchronized (scanner){
                    try{
                        while (scannerIsBusy){
                            wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    scannerIsBusy = true;
                    System.out.println("Документ пользователя №" + thread.getName() + "сканируется и " +
                            "печатается");
                    Thread.sleep(2000);
                    scannerIsBusy = false;
                    scanner.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printIsBusy = false;
            print.notifyAll();
        }
    }

    public void photocopierToPrint(){
        Thread thread = Thread.currentThread();
        synchronized (print){
            try{
                while(printIsBusy){
                    wait();
                }
                printIsBusy = true;
                synchronized (photocopier){
                    try {
                        while (photocopierIsBusy) {
                            wait();
                        }
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    photocopierIsBusy = true;
                    System.out.println("Документ пользователя №" + thread.getName() + " копируется и печатается");
                    Thread.sleep(2000);
                    photocopierIsBusy = false;
                    photocopier.notifyAll();
                }
                printIsBusy = false;
                print.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void photocopierToEmail(){
        Thread thread = Thread.currentThread();
        synchronized (photocopier){
            try{
                while(photocopierIsBusy){
                    wait();
                }
                photocopierIsBusy = true;
                System.out.println("Документ пользователя №" + thread.getName() + " копируется и отправляется по Email");
                Thread.sleep(2000);
                photocopierIsBusy = false;
                photocopier.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void scannerToEmail(){
        Thread thread = Thread.currentThread();
        synchronized (scanner){
            try{
                while(scannerIsBusy){
                    wait();
                }
                scannerIsBusy = true;
                System.out.println("Документ пользователя №" + thread.getName() + " сканируется и отправляется по Email");
                Thread.sleep(2000);
                scannerIsBusy = false;
                scanner.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
