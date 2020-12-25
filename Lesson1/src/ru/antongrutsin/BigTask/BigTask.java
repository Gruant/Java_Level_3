package ru.antongrutsin.BigTask;

public class BigTask {
    public static void main(String[] args) {
        Box<Apple> boxApple = new Box<>(new Apple(), 3);
        Box<Apple> boxApple2 = new Box<>(new Apple(), 4);

        Box<Orange> orangeBox = new Box<>(new Orange(), 4);

        System.out.println(boxApple.isCompare(boxApple2));

        System.out.println(boxApple.getStorage().size());

        boxApple.pourOver(boxApple2);
        System.out.println(boxApple.getStorage().size());
        System.out.println(boxApple2.getStorage().size());
        boxApple.add(new Apple());
        System.out.println(boxApple2.getWeight());
        System.out.println(boxApple.getStorage().size());
    }
}
