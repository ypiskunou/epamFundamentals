package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 11. Матрицу 10x20 заполнить случайными числами от 0 до 15.
 * Вывести на экран саму матрицу и номера строк, в которых число 5 встречается три и более раз.
 * @since 21.10.20
 */
public class Task11 {

    public static void main(String[] args) {

        int[][] array = new int[10][20];

        System.out.print("Rows where 5 appears more than 2 times: ");
        for (int i = 0; i < array.length; i++) {
            int counter = 0;
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) (Math.random() * 16);

                if (array[i][j] == 5)
                    counter++;
            }
            if (counter > 2)
                System.out.print(i+1 + " ");
        }

        System.out.printf("\nThe original array: \n%s", Task1.print2dArray(array));
    }
}