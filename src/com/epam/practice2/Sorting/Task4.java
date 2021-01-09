package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 4. Дана  последовательность  чисел. Требуется  переставить  числа  в порядке  возрастания.
 * Для  этого  сравниваются  два  соседних  числа, делается перестановка.
 * Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 * @since 14.11.20
 */
public class Task4 {

    public static void main(String[] args) {
        //int[] array = new int[]{77, 33, 55, 11, 22, 5, 7, 3, 77};
        int[] array = new int[]{3, 5, 7, 11, 22, 33, 55, 55, 77};
        System.out.printf("Original array: %s\n", Arrays.toString(array));

        int total = sortByExchange(array);

        System.out.printf("Resulting array: %s\n", Arrays.toString(array));
        System.out.printf("Total swaps: %d", total);
    }

    private static int sortByExchange(int[] array){
        int total = 0;
        int counter = 1;
        while (counter != 0) {
            counter = 0;
            for (int i = 0; i < array.length - 1; i++)
                if (array[i] > array[i + 1]) {
                    swapArrayElements(i, i + 1, array);
                    counter++;
                }
            total += counter;
        }

        return total;
    }

    private static void swapArrayElements(int i, int j, int[] vector) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }
}