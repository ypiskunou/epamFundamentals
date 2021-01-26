package com.epam.practice3.StringObject;

/**
 * @author Piskunou Yury
 * @my.task 3. Проверить, является ли заданное слово палиндромом.
 * @since 09.01.21
 */

public class Task3 {
    private static String word = "madams";

    public static void main(String[] args) {
        System.out.printf("The word %s is %sa polindrom", word, (isPolindrom(word) ? "" : "not "));
    }

    private static boolean isPolindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }
}
