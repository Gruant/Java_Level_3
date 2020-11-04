package ru.antongrutsin.BigTask;

import java.util.ArrayList;

public class Box<T extends Fruit>{
    private T obj;
    private final ArrayList<T> storage = new ArrayList<>();

    public Box() {
    }

    public Box(T obj, int value) {
        this.obj = obj;

        for (int i = 0; i < value; i++) {
            this.storage.add(i, obj);
        }
    }

    public T getObj() {
        return obj;
    }

    public void add(T obj){
        this.storage.add(obj);
    }

    public void clearStorage() {
        this.storage.clear();
    }

    public float getWeight() {
        return storage.size() * obj.getWeight();
    }

    public ArrayList<T> getStorage(){
        return this.storage;
    }

    public boolean isCompare(Box<T> box) {
        return this.getWeight() == box.getWeight();
    }

    public void pourOver (Box<T> box){
        box.storage.addAll(this.storage);
        this.clearStorage();
    }
}
