package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 * @since 24.11.20
 */
public class Task7 {

    public static void main(String[] args) {

        System.out.printf("Sum of odd numbers factorials is %d ", sumOfOddFactorialsOf9());
    }

    private static int sumOfOddFactorialsOf9() {
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i < 9; i++) {
            factorial *= i;
            if (i % 2 != 0) sum += factorial;
        }

        return sum;
    }
}