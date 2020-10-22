package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @since 21.10.20
 * @my.task 4. Даны действительные числа а1, а2  ,..., аn. Поменять местами наибольший и наименьший элементы.
 * */
public class Task4 {

    public static void main(String[] args) {
        int[] array = new int[]{48, -23, 23, 0, 65, 36, -8};

        System.out.printf("Original array is %s\nAltered array is %s",
                Arrays.toString(array), Arrays.toString(swapMinMaxInArray(array)));
    }

    private static int[] swapMinMaxInArray(int[] array){
        int max = array[0];
        int min = array[0];
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
                indexMax = i;
            }
            else if (array[i] < min){
                min = array[i];
                indexMin = i;
            }
        }

        array[indexMax]= min;
        array[indexMin] = max;

        return array;
    }
}