package com.epam.practice2.Array2D;

import static com.epam.practice2.Array2D.Task1.stringify2dArray;
import static com.epam.practice2.Array2D.Task12.getArrayOnInfoArray;

/**
 * @author Piskunou Yury
 * @my.task 13. Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.
 * @since 03.11.20
 */
public class Task13 {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {27, 8, 0, 27},
                {3, 5, 4, 3},
                {3, 3, 7, 25},
                {3, 3, 7, 25}
        };

        System.out.printf("Original array: \n%s", Task1.stringify2dArray(array));

        System.out.println("\nSorted array: ");
        int[][] transposedArray = transposeMatrix(array);
        InfoArray infoArray = new InfoArray(transposedArray);
        infoArray.sortMatrixOnRows(transposedArray);
        int[][] sortedArray = getArrayOnInfoArray(transposedArray, infoArray.getReferenceArray());

        System.out.println(Task1.stringify2dArray(transposeMatrix(sortedArray)));
    }

    private static int[][] transposeMatrix(int[][] array) {
        int[][] transposedArray = new int[array[0].length][array.length];
        for (int i = 0; i < array[0].length; i++)
            for (int j = 0; j < array.length; j++)
                transposedArray[i][j] = array[j][i];

        return transposedArray;
    }
}