package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 17.  Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
 * Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 * @since 21.12.20
 */
public class Task17 {

    private static int n = 100001;

    public static void main(String[] args) {
        System.out.printf("Quantity of operations is %d\n", operationsQuantity(n));
    }

    private static int operationsQuantity(int n) {
        int quantity = 0;
        while (n > 0) {
            n -= sumOfDigits(n);
            quantity++;
        }

        return quantity;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        int[] digits = arrayOfDigits(number);
        for (int i = 0; i < digits.length; i++)
            sum += digits[i];

        return sum;
    }

    private static int[] arrayOfDigits(int n) {
        char[] numberString = Integer.toString(n).toCharArray();
        int[] digits = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++)
            digits[i] = (int) numberString[i] - 48;

        return digits;
    }
}