package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 3. Сортировка выбором. Дана возрастающая последовательность чисел.
 * Требуется переставить элементы так, чтобы они были расположены по убыванию.
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место,
 * а первый - на место наибольшего. Затем, начиная со второго, эта процедура повторяется.
 * Написать алгоритм сортировки выбором.
 * @since 14.11.20
 */
public class Task3 {

    static int[] array;

    public static void main(String[] args) {
        array = new int[]{3, 5, 7, 11, 22, 33, 55, 55, 77};
        System.out.printf("Original array: %s\n", Arrays.toString(array));

//        for (int i = 0; i < array.length / 2; i++) // for sorted array
//            swapArrayElements(i, array.length - 1 - i, array);
        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[j] > array[i])
                    swapArrayElements(i, j, array);

        System.out.printf("Resulting array: %s", Arrays.toString(array));
    }

    static void swapArrayElements(int i, int j, int[] vector) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }
}