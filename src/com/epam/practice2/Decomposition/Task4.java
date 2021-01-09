package com.epam.practice2.Decomposition;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 4. На плоскости заданы своими координатами n точек.
 * Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние.
 * Указание. Координаты точек занести в массив.
 * @since 24.11.20
 */
public class Task4 {

    public static void main(String[] args) {

        int[] x = new int[]{7, 11, 14, 4, 5, 8, 3, 17, 18, 5, 3, 18, 3, 2};
        int[] y = new int[]{3, 5, 12, 14, 15, 16, 5, 14, 25, 7, 24, 5, 7, 8};

        double max = -1;
        double distance;
        int maxIndex1 = 0;
        int maxIndex2 = 1;

        for (int i = 0; i < x.length - 1; i++)
            for (int j = i + 1; j < x.length; j++) {
                distance = distanceBetweenTwoPoints(x[i], y[i], x[j], y[j]);
                if (distance > max) {
                    max = distance;
                    maxIndex1 = i;
                    maxIndex2 = j;
                }
            }

        System.out.printf("The maximal distance %.2f is between %d and %d points. ", max, maxIndex1 + 1, maxIndex2 + 1);
    }

    private static double distanceBetweenTwoPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}