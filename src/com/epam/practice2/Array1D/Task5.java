package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 5. Даны целые числа а1, а2  ,..., аn  . Вывести на печать только те числа, для которых а[i] > i.
 * @since 21.10.20
 */
public class Task5 {

    public static void main(String[] args) {
        int[] array = new int[]{48, -23, 23, 0, 65, 36, -8};
        System.out.printf("Original array %s\nElements larger than indices: ", Arrays.toString(array));
        for (int i = 0; i < array.length; i++)
            if (array[i] > i) System.out.print(array[i] + " ");
    }
}