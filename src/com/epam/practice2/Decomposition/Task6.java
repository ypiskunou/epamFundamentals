package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 * @since 24.11.20
 */
public class Task6 {

    public static void main(String[] args) {

        int a = 14;
        int b = 17;
        int c = 15;

        System.out.printf("Numbers %d, %d, %d are ", a, b, c);
        System.out.print(isRelativePrime(a, b, c) ? "relative primes " : "Not relative primes. ");
    }

    private static boolean isRelativePrime(int a, int b, int c) {
        return gcd(a, b) == 1 && gcd(a, c) == 1 && gcd(b, c) == 1;
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
}