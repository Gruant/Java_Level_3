package ru.antongrutsin.BigTask;

public class Orange extends Fruit {
    private final float weight = 1.5f;

    @Override
    public String toString() {
        return "Апельсины";
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
