package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @since 21.10.20
 * @my.task 2. Дана последовательность действительных чисел а1, а2  ,..., аn .
 * Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
 * */
public class Task2 {

    public static void main(String[] args) {
        int[] array = new int[]{48, 23, 23, 21, 65, 36, 8};
        final int Z = 22;
        int sum = 0;
        int counter = 0;
        for(int i = 0; i < array.length; i++)
            if(array[i] > Z){
                array[i] = Z;
                counter++;
        }
        System.out.printf("%d inserts were done to array %s", counter, Arrays.toString(array));
    }
}