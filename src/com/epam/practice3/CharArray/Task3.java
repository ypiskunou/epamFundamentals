package com.epam.practice3.CharArray;

/**
 * @author Piskunou Yury
 * @my.task 3. В строке найти количество цифр.
 * @since 04.01.21
 */
public class Task3 {

    private static String text = "Numbers. There are infinite primes: 1, 2, 3, 5. And only one even among them: 2.";

    public static void main(String[] args) {

        System.out.println("The text is: " + text);
        System.out.println("There are " + countDigits(text) + " digits in the text");
    }

    private static int countDigits(String s) {
        char[] sChars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < sChars.length; i++)
            if (sChars[i] >= 48 && sChars[i] <= 57)
                count++;

        return count;
    }
}

