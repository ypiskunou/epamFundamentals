package com.epam.practice2.Array2D;

import java.util.Scanner;

/**
 * @author Piskunou Yury
 * @my.task 8. В числовой матрице поменять местами два столбца любых столбца,
 * т. е. все элементы одного столбца поставить на соответствующие им позиции другого,
 * а его элементы второго переместить в первый. Номера столбцов вводит пользователь с клавиатуры.
 * @since 21.10.20
 */
public class Task8 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, -8, 3, 27},
                {7, 2, 4, 3},
                {8, 12, 4, 21},
                {2, 3, 1, 25}
        };
        System.out.printf("Original array: \n%s", Task1.print2dArray(array));

        Scanner scanner;
        String input;
        String[] columns;

        int leftColumn = -1;
        int rightColumn = -1;
        do {
            do {
                System.out.printf("\nEnter two numbers of columns from 1 to %d - to swap them.\n", array[0].length);
                scanner = new Scanner(System.in);
                input = scanner.findInLine("^\\d(,\\s*|\\s+)\\d");
            } while (input == null);
            System.out.println(input);
            columns = input.split("[, ]");
            leftColumn = Integer.parseInt(columns[0]) - 1;
            rightColumn = Integer.parseInt(columns[1]) - 1;
        } while (leftColumn < 0 || leftColumn >= array[0].length
                || rightColumn < 0 || rightColumn >= array[0].length);

        scanner.close();
        int temp;
        for (int i = 0; i < array.length; i++) {
            temp = array[i][leftColumn];
            array[i][leftColumn] = array[i][rightColumn];
            array[i][rightColumn] = temp;
        }

        System.out.printf("\nNew array: \n%s", Task1.print2dArray(array));
    }
}