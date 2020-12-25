package ru.antongrutsin;

public class Main {

    public static void main(String[] args) {
        int value = 0;
        int n = 5, m = 7;
        int i = 0, j = 0;
        int point = 0;

        int[][] matrix = new int[n][m];

        while (value <= n * m) {
            matrix[i][j] = ++value;

            if ((i == point) && (j < m - point - 1)) { j++; }
            else if ((j == m - point - 1) && (i < n - point - 1)) { i++; }
            else if ((i == n - point - 1) && (j > point)) { j--; }
            else { i--; }

            if ((i == point + 1) && (j == point)){
                point++;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
