package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 16. Написать  программу,  определяющую  сумму  n  -  значных  чисел,  содержащих  только  нечетные  цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 * @since 21.12.20
 */
public class Task16 {

    private static int n = 97; //overload on n equal to 98

    public static void main(String[] args) {
        System.out.println("Required sum is: " + sumOfOddDigitsN(n));
        System.out.printf("Quantity of even subset for %d digits is %d\n", n, evenQuantity(sumOfOddDigitsN(n)));
    }

    private static long sumOfOddDigitsN(int n) {
        return 25 * n * (long) Math.pow(5, n - 1);
    }

    private static int evenQuantity(long sum) {
        int quantity = 0;
        int[] digits = arrayOfDigits(sum);
        for (int i = 0; i < digits.length; i++)
            if (digits[i] % 2 == 0)
                quantity++;

        return quantity;
    }

    private static int[] arrayOfDigits(long n) {
        char[] numberString = Long.toString(n).toCharArray();
        int[] digits = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++)
            digits[i] = (int) numberString[i] - 48;

        return digits;
    }
}