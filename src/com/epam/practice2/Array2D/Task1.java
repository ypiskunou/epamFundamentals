package com.epam.practice2.Array2D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 10.  Дан  целочисленный  массив  с  количеством  элементов  n.
 * Сжать  массив,  выбросив  из  него  каждый  второй элемент (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать.
 * @since 21.10.20
 */
public class Task1 {

    public static void main(String[] args) {
        int[] array = new int[]{4, -8, 3, 0, 65, 36, -8, 2, 25, 7, 81, 12, 4};
        System.out.printf("Original array %s\n", Arrays.toString(array));

        int counter = 0;
        for (int i = 0; i < array.length; i++)
            if (i % 2 == 0) {
                array[counter] = array[i];
                counter++;
            }

        for (int i = array.length - 1; array.length - counter > 0; i--, counter++)
            array[i] = 0;

        System.out.printf("New array %s", Arrays.toString(array));
    }
}