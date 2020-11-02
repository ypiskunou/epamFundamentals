package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 * @since 21.10.20
 */
public class Task3 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, -8, 3, 27},
                {7, 2, 4, 3},
                {8, 12, 4, 21},
                {2, 3, 1, 25}
        };

        int k = 3;
        int p = 2;

        System.out.printf("%s row of given matrix: ", getOrdinal(k + 1));
        for (int i = 0; i < array.length; i++)
            System.out.print(array[k][i] + " ");

        System.out.printf("\n%s column of given matrix: ", getOrdinal(p + 1));
        for (int j = 0; j < array[0].length; j++)
            System.out.print(array[j][p] + " ");
    }

    private static String getOrdinal(int i) {
        if (i == 1)
            return i + "st";
        else if (i == 2)
            return i + "nd";
        else if (i == 3) return i + "rd";
        else return i + "th";
    }
}