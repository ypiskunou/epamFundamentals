package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
 * Для решения задачи использовать декомпозицию.
 * @since 16.12.20
 */
public class Task13 {

    private static int a = 3;
    private static int b = 2 * a;

    public static void main(String[] args) {
        System.out.printf("Twins between %d and %d: \n", a, b);
        if (a % 2 == 0) a++;
        for (int i = a; i < b - 1; i += 2)
            if (isTwin(i)) {
                System.out.print(i + ", " + (i + 2) + "; ");
                i += 2;
            }
        System.out.print("\b\b.");
    }

    private static boolean isTwin(int n) {
        return (isPrime(n) && isPrime(n + 2));
    }

    private static boolean isPrime(int p) {

        if (p == 2) return true;
        if (p % 2 == 0)
            return false;
        else
            for (int i = 3; i < Math.sqrt(p); i += 2)
                if (p % i == 0) return false;

        return true;
    }
}