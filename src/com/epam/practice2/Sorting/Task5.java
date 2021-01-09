package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 5. Дана последовательность чисел.
 * Требуется переставить числа в порядке возрастания.  Делается  это  следующим  образом.
 * Пусть упорядоченная  последовательность. Берется  следующее  число и  вставляется  в  последовательность  так,
 * чтобы  новая последовательность была тоже возрастающей.
 * Процесс производится до тех пор, пока все элементы от i+1 до n не будут перебраны.
 * Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью двоичного поиска.
 * Двоичный поиск оформить в виде отдельной функции.
 * @since 14.11.20
 */
public class Task5 {

    public static void main(String[] args) {
        //int[] array = new int[]{77, 77, 55, 11, 22, 5, 7, 3, 1};
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 2000);

        System.out.printf("Original array: %s\n", Arrays.toString(array));

        sortByInserts(array);

        System.out.printf("Resulting array: %s", Arrays.toString(array));
    }

    private static int getElementAndShiftArrayToIndex(int insert, int index, int[] array) {
        int key = array[index];
        for (int i = index; i > insert; i--)
            array[i] = array[i - 1];

        return key;
    }

    private static void sortByInserts(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int toInsert = binarySearchIndex(array[i], array, i-1);
            array[toInsert] = getElementAndShiftArrayToIndex(toInsert, i, array);
        }

    }

    private static int binarySearchIndex(int key, int[] array, int rightBound) {
        int lo = 0;
        int hi = rightBound;

        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (key < array[mid]) hi = mid - 1;
            else if (key > array[mid]) lo = mid + 1;
            else return mid;
        }

        return lo;
    }
}