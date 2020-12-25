package ru.antongrutsin.Lesson5;


import java.util.concurrent.BrokenBarrierException;

import static ru.antongrutsin.Lesson5.Main.*;

public class Car implements Runnable{
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;

    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            try{
                prepareBarrier.await();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if (i == race.getStages().size()-1 && place.incrementAndGet() == 1) {
                System.out.println("" + this.name + " WIN");
            }
            if (i == race.getStages().size()-1){
               try {
                   raceEnd.await();
               } catch (InterruptedException | BrokenBarrierException e) {
                   e.printStackTrace();
               }
            }
        }
    }
}
