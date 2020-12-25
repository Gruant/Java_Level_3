package ru.antongrutsin;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        replaceElements(array, 1, 2);
        System.out.println(Arrays.toString(array));
        System.out.println(toArrayList(array).getClass());
        }
    //Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static <T> void replaceElements (T[] items, int i, int j) {
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
        }
    //Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<?> toArrayList (T[] items) {
        return new ArrayList<T>(Arrays.asList(items));
    }
}




