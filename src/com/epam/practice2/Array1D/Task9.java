package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 * @since 21.10.20
 */
public class Task9 {

    public static void main(String[] args) {
        int[] array = new int[]{4, -8, 3, 0, 65, 36, -8, 2, 0, 7};
        //int[] array = new int[]{4, 4, 4, 4, 4, 4};
        int[] infoArray = new int[array.length];
        int mostCommon = array[0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++)
                if (array[i] == array[j])
                    infoArray[i]++;
        }

        int max = infoArray[0];
        for (int i = 0; i < infoArray.length; i++)
            if (infoArray[i] > max)
                max = infoArray[i];

        for (int i = 0; i < infoArray.length; i++)
            if (infoArray[i] == max)
                infoArray[i] = -i;

        for (int i = 0; i < infoArray.length; i++)
            if (infoArray[i] == -i)
                if (array[i] < mostCommon)
                    mostCommon = array[i];

        System.out.printf("Original array %s\n", Arrays.toString(array));
        System.out.printf("Most common number is %d", mostCommon);
    }
}