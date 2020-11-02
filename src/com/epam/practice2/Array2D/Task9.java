package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 9. Задана  матрица  неотрицательных  чисел.
 * Посчитать  сумму  элементов  в  каждом  столбце.
 * Определить,  какой столбец содержит максимальную сумму.
 * @since 21.10.20
 */
public class Task9 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, -8, 3, 27},
                {7, 2, 4, 3},
                {8, 12, 4, 21},
                {2, 3, 1, 25}
        };

        int maxSum = 0;
        int tempSum = 0;

        for (int j = 0; j < array[0].length; j++) {
            for (int i = 0; i < array.length; i++)
                tempSum += array[i][j];

            if (maxSum < tempSum)
                maxSum = tempSum;

            tempSum = 0;
        }

        System.out.printf("Original matrix:\n%s", Task1.print2dArray(array));
        System.out.printf("\nMax Sum of elements of column at matrix is %d", maxSum);
    }
}