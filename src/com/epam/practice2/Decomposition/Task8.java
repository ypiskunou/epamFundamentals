package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы
 * трех последовательно расположенных элементов массива с номерами от k до m.
 * @since 24.11.20
 */
public class Task8 {

    public static void main(String[] args) {

        int[] a = new int[]{7, 11, 14, 4, 5, 8, 3, 17, 18, 5, 3, 18, 3, 2};

        System.out.printf("The sum of threes starting from 1, 3, 4 is %d. ", totalSumOfThrees(a, new int[]{1, 3, 4}));
    }

    private static int sumOfThreeElements(int[] a, int k) {
        if (k < 0 || k > a.length - 3) throw new IllegalArgumentException();
        int sum = 0;
        for (int i = k; i < k + 3; i++)
            sum += a[k];

        return sum;
    }

    private static int totalSumOfThrees(int[] a, int[] indecies) {
        int sum = 0;
        for (int i = 0; i < indecies.length; i++)
            sum += sumOfThreeElements(a, indecies[i]);

        return sum;
    }
}