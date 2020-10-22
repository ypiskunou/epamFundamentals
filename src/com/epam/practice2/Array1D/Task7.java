package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task Найти max из суммы крайних элементов при движении к центру
 * @since 21.10.20
 */
public class Task7 {

    public static void main(String[] args) {
        double[] array = new double[]{4, -2, 3, 0, 65, 36, -8, 2, 0, 7};
        double max = array[0] + array[array.length - 1];
        double temp;

        for (int i = 1; i < array.length - 1; i++)
            if ((temp = array[i] + array[array.length - 1 - i]) > max) max = temp;

        System.out.printf("Original array %s\n", Arrays.toString(array));
        System.out.printf("Max sum of side elements: %.1f", max);
    }
}