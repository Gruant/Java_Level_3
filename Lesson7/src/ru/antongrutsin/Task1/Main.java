package ru.antongrutsin.Task1;

public class Main {

    public static void main(String[] args) {
        TestingClass testing = new TestingClass();
        Testing.start(TestingClass.class);
        Testing.start(testing);
    }
}
