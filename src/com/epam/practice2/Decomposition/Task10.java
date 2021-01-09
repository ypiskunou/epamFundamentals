package com.epam.practice2.Decomposition;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 10.  Дано  натуральное  число  N.
 * Написать  метод(методы)  для  формирования  массива, элементами  которого являются цифры числа N.
 * @since 24.11.20
 */
public class Task10 {

    public static void main(String[] args) {

        int number = 12347890;

        System.out.printf("The array of digits of number %d is %s. ", number, Arrays.toString(arrayOfDigits(number)));
    }

    private static int[] arrayOfDigits(int n) {

        char[] numberString = Integer.toString(n).toCharArray();
        int[] digits = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++)
            digits[i] = (int) numberString[i] - 48;

        return digits;
    }
}