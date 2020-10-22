package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 8. Дана  последовательность  целых  чисел.  Образовать  новую  последовательность,  выбросив  из
 * исходной те члены, которые равны min
 * @since 21.10.20
 */
public class Task8 {

    public static void main(String[] args) {
        int[] array = new int[]{4, -8, 3, 0, 65, 36, -8, 2, 0, 7};
        //int[] array = new int[]{4, 4, 4, 4, 4, 4};
        int min = array[0];
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                counter = 1;
            } else if
                    (array[i] == min) counter++;
        }

        if (counter == array.length) {
            System.out.println("All elements are equal");
            return;
        }
        int[] arrayWithoutMins = new int[array.length - counter];
        for (int i = 0, j = 0; j < arrayWithoutMins.length || i < array.length; i++)
            if (array[i] != min) {
                arrayWithoutMins[j] = array[i];
                j++;
            }


        System.out.printf("Original array %s\n", Arrays.toString(array));
        System.out.printf("New array %s\n", Arrays.toString(arrayWithoutMins));
    }
}