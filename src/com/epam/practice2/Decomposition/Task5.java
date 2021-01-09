package com.epam.practice2.Decomposition;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
 * которое меньше максимального элемента массива, но больше всех других элементов).
 * @since 24.11.20
 */
public class Task5 {

    public static void main(String[] args) {

        int[] a = new int[]{20, 11, 14, 4, 5, 8, 3, 17, 18, 5, 21, 18, 3, 2};
        int max = a[0];
        int secondToMax = max;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                secondToMax = max;
                max = a[i];
            }
        }

        System.out.printf("The second maximal number is %d. ", secondToMax);
    }
}