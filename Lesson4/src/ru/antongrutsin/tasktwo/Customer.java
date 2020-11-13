package ru.antongrutsin.tasktwo;

import java.util.Random;

public class Customer implements Runnable{
    String name;
    MFU mfu;
    int rand;
    Random random = new Random();

    Customer(MFU mfu, String name){
        this.mfu = mfu;
        this.name = name;
        rand = random.nextInt(4);
    }


    @Override
    public void run() {
        if(rand == 0) {
            System.out.println("Пользователь №"+ this.name + " отправил документы на печать");
            mfu.printer();
        } else if(rand == 1){
            System.out.println("Пользователь №"+ this.name + " хочет отсканировать документ и распечатать его");
            mfu.scannerForPrint();
        } else if(rand == 2){
            System.out.println("Пользователь №"+ this.name + " хочет сделать копию и распечатать ее");
            mfu.photocopierToPrint();
        } else if(rand == 3){
            System.out.println("Пользователь №"+ this.name + " хочет отсканировать и отправить по Email");
            mfu.scannerToEmail();
        } else {
            System.out.println("Пользователь №"+ this.name + " хочет сделать копию и отправить ее по Email");
            mfu.photocopierToEmail();
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}



