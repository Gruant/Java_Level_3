package ru.antongrutsin.Task2;

import java.util.Arrays;

public class TestMethod {

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(arr1);
        int[] arr2 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertBitArray(arr2);
        int[] arr3 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArrayWithXor(arr3);
        int[] arr4 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArrayTernaryOperator(arr4);
        fillArray();
        doubleIntLessSix();
        fillDiagonal();
        findMinMax();
        int[] array5 = {1, 1, 1, 2, 1};
        System.out.println(isEqualLeftAndRight(array5));
        int[] array6 = {1, 2, 3, 4, 5};
        arrayOffset(array6, 0);
    }

    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    static void invertArray(int[] arr) {
        System.out.println("Задача 1 - SWITCH\nИсходный массив: \t\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
        System.out.println();
    }

    // Задание 1: дополнение к 1ому заданию - выполните его таким образом, чтобы не использовались
    // условные операторы (if/else или switch/case)
    static void invertBitArray(int[] arr){
        System.out.println("Задача 1 - Логическое НЕ\nИсходный массив: \t\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            arr[i] = ~arr[i] + 2;
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
        System.out.println();
    }

    // Задание 1: дополнение к 1ому заданию - выполните его таким образом, чтобы не использовались
    // условные операторы (if/else или switch/case)
    static void invertArrayWithXor(int[] arr){
        System.out.println("Задача 1 - Побитовое исключающее ИЛИ\nИсходный массив: \t\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            arr[i] ^= 1;
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
        System.out.println();
    }

    // Задание 1: дополнение к 1ому заданию - выполните его таким образом, чтобы не использовались
    // условные операторы (if/else или switch/case)
    static void invertArrayTernaryOperator(int[] arr){
        System.out.println("Задача 1 - Тернарный оператор\nИсходный массив: \t\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
        System.out.println();
    }

    // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static void fillArray() {
        int[] arr = new int[8];
        int factor = 3;

        System.out.println("Задача 2\nИсходный массив: \t\t" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * factor;
        }

        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
        System.out.println();
    }

    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static void doubleIntLessSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задача 3\nИсходный массив: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
        System.out.println();
    }

    /*
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    static void fillDiagonal() {
        int[][] arr = new int[9][9];

        System.out.println("Задача 4\nИсходный двумерный массив: ");
        printMatrix(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][(arr.length - 1) - i] = 1;
        }
        System.out.println("Преобразованный двумерный массив: ");
        printMatrix(arr);
    }

    // Метод для вывода двумерного массива
    static void printMatrix(int[][] arr) {
        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + "\t");
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    // Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета)
    static void findMinMax() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задача 5\nИсходный массив: " + Arrays.toString(arr));

        int max, min;
        max = min = arr[0];


        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        System.out.println("Минималное значение массива: " + min);
        System.out.println("Максимальное значение массива: " + max);
        System.out.println();
    }

    /*
    Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
    true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    граница показана символами ||, эти символы в массив не входят.
     */

    static boolean isEqualLeftAndRight(int[] array) {
        System.out.println("Задача 6\nИсходный массив: " + Arrays.toString(array));

        int leftSum = 0;

        // 2, 1, 1
        for (int i = 0; i < array.length - 1; i++) {
            leftSum += array[i];
            int rightSum = 0;
            for (int k = array.length - 1; i < k; k--) {
                rightSum += array[k];
                if (i == (k - 1) && leftSum == rightSum) {
                    return true;
                }
            }

        }
        return false;
    }

    /*
    Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться
    вспомогательными массивами.
     */

    static void arrayOffset(int[] array, int n) {
        System.out.println();
        System.out.println("Задача 7\nИсходный массив: " + Arrays.toString(array) + "\nСмещение на " + n + " позиций");

        if (n > 0) {
            for (; n > 0; n--) {
                int val = array[array.length - 1];
                for (int i = array.length - 1; i > -1; i--) {
                    if (i == 0) {
                        array[0] = val;
                    } else {
                        array[i] = array[i - 1];
                    }
                }
            }
        } else {
            for (; n < 0; n++){
                int val = array[0];
                for (int i = 0; i < array.length; i++) {
                    if (i == array.length-1) {
                        array[array.length-1] = val;
                    } else {
                        array[i] = array[i+1];
                    }
                }
            }
        }
        System.out.println("Преобразованный массив: " + Arrays.toString(array));
    }


}
