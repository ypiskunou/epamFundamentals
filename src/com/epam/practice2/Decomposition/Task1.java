package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 1. Написать метод(методы) для нахождения наибольшего общего делителя и
 * наименьшего общего кратного двух натуральных чисел
 * @since 24.11.20
 */
public class Task1 {

    public static void main(String[] args) {

        int a = 9_639;
        int b = 15_708;

        System.out.printf("For %d and %d\n gcd is %d,\n lcm is %d", a, b, gcd(a, b), lcm(a, b));
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

    private static long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }
}