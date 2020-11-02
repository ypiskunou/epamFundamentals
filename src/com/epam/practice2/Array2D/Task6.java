package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * @since 21.10.20
 */
public class Task6 {

    public static void main(String[] args) {
        int n = 8;
        int[][] array = new int[n][n];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (i < array.length / 2) {
                    if (j >= i && j < n - i)
                        array[i][j] = 1;
                } else if (i >= j && j >= n - 1 - i)
                    array[i][j] = 1;

        System.out.printf("Resulting matrix: \n%s", Task1.print2dArray(array));
    }
}