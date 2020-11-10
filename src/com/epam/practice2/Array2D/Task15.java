package com.epam.practice2.Array2D;

import static com.epam.practice2.Array2D.Task1.stringify2dArray;
import static com.epam.practice2.Array2D.Task12.getArrayOnInfoArray;

/**
 * @author Piskunou Yury
 * @my.task 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 * @since 03.11.20
 */
public class Task15 {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {27, 8, 0, 27},
                {3, 5, 4, 3},
                {3, 3, 7, 25},
                {3, 3, 7, 25}
        };

        System.out.printf("Original array: \n%s", Task1.stringify2dArray(array));

        System.out.println("\nNew array: ");

        System.out.println(Task1.stringify2dArray(changeElementAtOddPlaces(array, findMaxAtMatrix(array))));
    }

    private static int[][] changeElementAtOddPlaces(int[][] array, int element) {
        for (int i = 0, counter = 1; i < array.length; i++)
            for (int j = 0; j < array.length; j++, counter++)
                if (counter % 2 != 0)
                    array[i][j] = element;
        return array;
    }

    private static int findMaxAtMatrix(int[][] array){
        int max = array[0][0];
        for (int i = 0, counter = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++, counter++)
                if(array[i][j]>max)
                    max = array[i][j];
        return max;
    }
}