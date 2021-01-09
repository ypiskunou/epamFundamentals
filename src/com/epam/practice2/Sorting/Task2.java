package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 2. Даны две последовательности. Неубывающие.
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей.
 * Примечание. Дополнительный массив не использовать.
 * @since 14.11.20
 */
public class Task2 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5, 7, 11, 22, 55, 55, 77, 88, 88, 88, 88};
        int[] array2 = new int[]{2, 4, 8, 10, 33};

        System.out.printf("Destination array: %s\n", Arrays.toString(array1));
        System.out.printf("Insert array: %s\n", Arrays.toString(array2));

        if (array1.length > array2.length)
            for (int anInsert : array2)
                findElementToShiftAndInsert(anInsert, array1);
        else
            for (int anDestination : array1)
                findElementToShiftAndInsert(anDestination, array2);

        System.out.printf("Resulting array: %s", Arrays.toString(array1));
    }

    private static void shiftArrayToRight(int index, int[] destination) {
        for (int i = destination.length - 1; i > index; i--)
            destination[i] = destination[i - 1];
    }

    private static void findElementToShiftAndInsert(int insertElement, int[] destination) {
        for (int i = 0; i < destination.length; i++)
            if (insertElement <= destination[i]) {
                shiftArrayToRight(i, destination);
                destination[i] = insertElement;
                return;
            }
    }
}