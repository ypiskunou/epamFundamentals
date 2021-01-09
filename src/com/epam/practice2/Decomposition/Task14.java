package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 14.  Натуральное  число,  в  записи  которого  n  цифр,  называется  числом  Армстронга,
 * если  сумма  его  цифр, возведенная  в  степень  n,  равна  самому  числу.
 * Найти  все  числа  Армстронга  от  1  до  k.  Для  решения  задачи использовать декомпозицию.
 * @since 17.12.20
 */
public class Task14 {

    private static int k = 100500;

    public static void main(String[] args) {
        System.out.printf("Armstrong numbers between 1 and %d: \n", k);
        for (int i = 1; i <= k; i++)
            if (isArmstrongNumber(i))
                System.out.print(i + ", ");
        System.out.print("\b\b");
    }

    private static boolean isArmstrongNumber(int number) {

        int sum = 0;
        int[] digits = arrayOfDigits(number);
        for(int d:digits)
            sum+= Math.pow(d, digits.length);
        return sum == number;
    }

    private static int[] arrayOfDigits(int n) {
        char[] numberString = Integer.toString(n).toCharArray();
        int[] digits = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++)
            digits[i] = (int) numberString[i] - 48;

        return digits;
    }
}