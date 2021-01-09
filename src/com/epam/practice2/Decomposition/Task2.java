package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 1. Написать метод(методы) для нахождения наибольшего общего делителя четырёх натуральных чисел
 * @since 24.11.20
 */
public class Task2 {

    public static void main(String[] args) {

        int a = 9_639;
        int b = 15_708;
        int c = 63;
        int d = 119;

        System.out.printf("For %d, %d, %d and %d\n gcd is %d", a, b, c, d, gcdForFourNumbers(a, b, c, d));
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

    private static int gcdForFourNumbers(int a, int b, int c, int d) {
        return gcd(gcd(gcd(a, b), c), d);
    }
}