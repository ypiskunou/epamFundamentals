package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * @since 21.10.20
 */
public class Task5 {

    public static void main(String[] args) {
        int n = 8;
        int[][] array = new int[n][n];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (j < n-i)
                    array[i][j] = i + 1;
                else array[i][j] = 0;

        System.out.printf("Resulting matrix: \n%s", Task1.print2dArray(array));
    }
}