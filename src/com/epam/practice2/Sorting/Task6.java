package com.epam.practice2.Sorting;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 6. Дан  массив  n  действительных  чисел.  Требуется  упорядочить  его  по  возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1.
 * Если ai < ai+1, то продвигаются на  один  элемент  вперед.
 * Если ai > ai+1,  то  производится  перестановка  и  сдвигаются  на  один  элемент  назад.
 * Составить алгоритм этой сортировки Шелла.
 * @since 19.11.20
 */
public class Task6 {

    public static void main(String[] args) {
        //int[] array = new int[]{77, 77, 55, 11, 22, 5, 7, 3, 1};
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 2000);
        System.out.printf("Original array: %s\n", Arrays.toString(array));

        sortByShell(array);

        System.out.printf("Resulting array: %s", Arrays.toString(array));
    }

    private static void sortByShell(int[] array) {

        for (int step = array.length / 2; step > 0; step /= 2)
            for (int k = step; k < array.length; k++)
                for (int i = k - step; i >= 0 && array[i] > array[i + step]; i--) {
                    int temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                }

    }
}