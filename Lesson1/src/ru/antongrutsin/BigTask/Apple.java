package ru.antongrutsin.BigTask;

public class Apple extends Fruit{
    private final float weight = 1.1f;

    @Override
    public String toString() {
        return "Яблоки";
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
