package com.epam.practice2.Array2D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 * @since 21.10.20
 */
public class Task1 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, -8, 3, 27},
                {7, 2, 4, 3},
                {8, 12, 4, 21},
                {2, 3, 1, 25}
        };

        boolean[] isSuitableColumn = new boolean[array[0].length];
        int counter = 0;

        for (int j = 0; j < array[0].length; j++)
            if ((j + 1) % 2 != 0 && array[0][j] > array[array.length - 1][j]) {
                isSuitableColumn[j] = true;
                counter++;
            }


        int[][] newArray = new int[array.length][counter];
        for (int i = 0; i < array.length; i++)
            for (int j = 0, k = 0; j < array[0].length; j++) {
                if (isSuitableColumn[j]) {
                    newArray[i][k] = array[i][j];
                    k++;
                }
            }

        System.out.printf("Original array:\n%s", stringify2dArray(array));
        System.out.printf("\nNew array:\n%s", stringify2dArray(newArray));
    }

    public static String stringify2dArray(int[][] array) {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < array.length; i++)
            matrix.append(Arrays.toString(array[i]) + "\n");
        return matrix.toString();
    }

    public static String stringify2dArray(double[][] array) {
        StringBuilder matrix = new StringBuilder();
        for (int i = 0; i < array.length; i++)
            matrix.append(Arrays.toString(array[i]) + "\n");
        return matrix.toString();
    }
}