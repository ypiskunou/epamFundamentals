package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 * @since 17.12.20
 */
public class Task15 {

    private static int n = 7;

    public static void main(String[] args) {
        if (n > 9) throw new IllegalArgumentException("The number can't hold more than 9 ascending digits.");
        System.out.printf("Numbers with ascending digits with %d digits: \n", n);
        int start = 0;
        for (int i = n - 1, j = 1; i >= 0; i--, j++)
            start += j * (int) Math.pow(10, i);

        for (int i = start; i < (int) Math.pow(10, n); i++)
            if (isAscending(i))
                System.out.print(i + ", ");
        System.out.print("\b\b");
    }

    private static boolean isAscending(int number) {

        int[] digits = arrayOfDigits(number);
        for (int i = 1; i < digits.length; i++)
            if (digits[i - 1] >= digits[i])
                return false;
        return true;
    }

    private static int[] arrayOfDigits(int n) {
        char[] numberString = Integer.toString(n).toCharArray();
        int[] digits = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++)
            digits[i] = (int) numberString[i] - 48;

        return digits;
    }
}