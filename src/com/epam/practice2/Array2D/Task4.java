package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * @since 21.10.20
 */
public class Task4 {

    public static void main(String[] args) {
        int n = 8;
        int[][] array = new int[n][n];

        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (i % 2 == 0)
                    array[i][j] = j + 1;
                else array[i][j] = array.length - j;

        System.out.printf("Resulting matrix: \n%s", Task1.stringify2dArray(array));
    }
}