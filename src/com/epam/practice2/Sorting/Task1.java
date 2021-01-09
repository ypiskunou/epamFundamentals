package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объединить их в один  массив,  включив  второй  массив  между  k-м  и  (k+1)  -  м  элементами  первого,
 * при  этом  не  используя дополнительный массив.
 * @since 14.11.20
 */
public class Task1 {

    public static void main(String[] args) {
        int[] array1 = new int[]{48, 23, 21, 65, 36, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] array2 = new int[]{1, 2, 3, 4, 5};

        int k = 3;

        if (k + 1 + array2.length <= array1.length) {
            for (int i = k, j = 0; i < array2.length + k; i++, j++) {
                array1[i + array2.length] = array1[i];
                array1[i] = array2[j];
            }
        } else if(k + 1 + array1.length <= array2.length){
            for (int i = k, j = 0; i < array1.length + k; i++, j++) {
                array2[i + array1.length] = array2[i];
                array2[i] = array1[j];
            }
        }

        else System.out.println("Not enough space to insert one array into another ");

        System.out.printf("Resulting array: %s", Arrays.toString(array1));
    }
}