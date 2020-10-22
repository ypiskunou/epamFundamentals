package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @since 21.10.20
 * @my.task 3.  Дан  массив  действительных  чисел,  размерность  которого  N.
 * Подсчитать,  сколько  в  нем  отрицательных, положительных и нулевых элементов.
 * */
public class Task3 {

    public static void main(String[] args) {
        int[] array = new int[]{48, -23, 23, 0, 65, 36, -8};
        final int N = array.length;
        int positives = 0;
        int negatives = 0;
        for (int element : array) {
            if (element > 0)
                positives++;
            else if (element < 0) negatives++;
        }
        int nils = N - positives - negatives;

        System.out.printf("At given array %s: %d negatives, %d positives and %d nil%s",
                Arrays.toString(array), negatives, positives, nils, nils>1?"s":"");
    }
}