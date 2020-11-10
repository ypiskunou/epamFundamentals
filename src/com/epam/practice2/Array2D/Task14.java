package com.epam.practice2.Array2D;

import static com.epam.practice2.Array2D.Task1.stringify2dArray;
import static com.epam.practice2.Array2D.Task12.getArrayOnInfoArray;

/**
 * @author Piskunou Yury
 * @my.task 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
 * причем в каждом столбце число единиц равно номеру столбца.
 * @since 03.11.20
 */
public class Task14 {

    public static void main(String[] args) {
        final int m = 5;
        final int n = 5;
        int[][] array = new int[m][n];


        int t;
        int counter;
        for (int j = 0; j < n; j++) {
            counter = 0;
            while (counter < j + 1) {
                t = (int) (Math.random() * m);
                if (array[t][j] == 0)
                    array[t][j] = 1;
                else counter--;
                counter++;
            }
        }

        System.out.printf("Resulting matrix: \n%s", Task1.stringify2dArray(array));
    }
}