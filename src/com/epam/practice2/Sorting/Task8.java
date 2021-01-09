package com.epam.practice2.Sorting;

/**
 * @author Piskunou Yury
 * @my.task 8.Даны дроби (qi/pi, q,p - натуральные).
 * Составить программу, которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
 * @since 19.11.20
 */
public class Task8 {

    public static void main(String[] args) {

        int[] nominators = new int[]{7, 11, 14, 4, 5, 8, 3, 17, 18, 5, 3, 18, 3, 2};
        int[] denominators = new int[]{3, 5, 12, 14, 15, 16, 5, 14, 25, 7, 24, 5, 7, 8};
        int[] multipliers = new int[nominators.length];
        int[] nominatorsForCommonDenominator = new int[nominators.length];

        int lcm = findCommonDenominator(denominators);

        System.out.println("Original fractions: ");
        printFractions(nominators, denominators);

        for (int i = 0; i < multipliers.length; i++) {
            multipliers[i] = lcm / denominators[i];
            nominatorsForCommonDenominator[i] = nominators[i] * multipliers[i];
        }

        int min;
        int minValue;
        for (int i = 0; i < nominators.length; i++) {
            minValue = nominatorsForCommonDenominator[i];
            min = -1;
            for (int j = i; j < nominators.length; j++)
                if (nominatorsForCommonDenominator[j] < minValue) {
                    minValue = nominatorsForCommonDenominator[j];
                    min = j;
                }
            if (min > -1) {
                synchroSwap(nominators, denominators, min, i);
                swap(nominatorsForCommonDenominator, min, i);
            }
        }

        System.out.println("\n\nSorted fractions due to common fraction value: ");
        printFractions(nominators, denominators);
    }

    private static String stringifyFraction(int nominator, int denominator) {
        StringBuilder result = new StringBuilder("" + nominator);
        return result.append("/").append(denominator).toString();
    }

    private static void printFractions(int[] nominators, int[] denominators) {
        for (int i = 0; i < nominators.length; i++) {
            System.out.print(stringifyFraction(nominators[i], denominators[i]));
            if(i < nominators.length - 1)
                System.out.print(", ");
        }
    }

    private static void synchroSwap(int[] a, int[] b, int i, int j) {
        swap(a, i, j);
        swap(b, i, j);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0)
            return b;

        int r = a % b;
        while (r > 0) {
            a = b;
            b = r;
            r = a % b;
        }

        return b;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int findCommonDenominator(int[] denominators) {
        int result = lcm(denominators[0], denominators[1]);
        for (int i = 2; i < denominators.length; i++)
            result = lcm(result, denominators[i]);

        return result;
    }
}