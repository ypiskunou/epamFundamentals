package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 7.  Пусть  даны  две  неубывающие  последовательности  действительных  чисел.
 * Требуется указать те места, на которые нужно вставлять элементы последовательности в первую последовательность так,
 * чтобы новая последовательность оставалась возрастающей.
 * @since 19.11.20
 */
public class Task7 {

    public static void main(String[] args) {

        int[] a1 = new int[]{7, 11, 14, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] a2 = new int[]{3, 5, 12, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        int[] info = new int[a1.length];

        int i = 0, j = 0, q = 0;
        boolean toggle = false;

        for (int k = 0; k < a1.length + a2.length; k++) {
            if (i > a1.length - 1)
                j++;
            else if (j > a2.length - 1)
                i++;
            else if (a1[i] < a2[j]) {
                i++;
                toggle = true;
            } else {
                j++;
                if (toggle || q == 0) {
                    info[q++] = i + 1;
                    toggle = false;
                }
            }
        }

        System.out.printf("Original array a1: %s\n", Arrays.toString(a1));
        System.out.printf("Original array a2: %s\n", Arrays.toString(a2));

        System.out.printf("Places in array a1 to insert a2: %s", Arrays.toString(info));
    }
}