package ru.antongrutsin.Lesson5;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    private static final int CARS_COUNT = 4;
    static AtomicInteger place = new AtomicInteger(0);
    static final CyclicBarrier prepareBarrier = new CyclicBarrier(CARS_COUNT, new Announcements("Гонка началась"));
    static final CyclicBarrier raceEnd = new CyclicBarrier(CARS_COUNT, new Announcements("Гонка закончилась"));
    static final Semaphore sp = new Semaphore(CARS_COUNT/2, true);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }

    }

    public static class Announcements implements Runnable {
        public String type;

        Announcements(String type){
            this.type = type;
        }

        @Override
        public void run() {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + type);
        }
    }
}
