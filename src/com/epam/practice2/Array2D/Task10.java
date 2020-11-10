package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 10. Найти положительные элементы главной диагонали квадратной матрицы.
 * @since 21.10.20
 */
public class Task10 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, -8, 3, 27},
                {7, 2, 4, 3},
                {8, 12, 4, 21},
                {2, 3, 1, 25}
        };
        System.out.printf("Original array: \n%s", Task1.stringify2dArray(array));

        System.out.println("\nPositive elements at the diagonal: ");
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (i == j && array[i][j] > 0)
                    System.out.printf("%d ", array[i][j]);
    }
}