package com.epam.practice3.CharArray;

/**
 * @author Piskunou Yury
 * @my.task 4. В строке найти количество чисел.
 * @since 04.01.21
 */
public class Task4 {

    private static String text = "Numbers. There are infinite primes: 11, 13, 17, 19. And only one even among them: 2.";

    public static void main(String[] args) {

        System.out.println("The text is: " + text);
        System.out.println("There are " + countNumbers(text) + " numbers in the text");
    }

    private static int countNumbers(String s) {
        char[] sChars = new char[s.length() + 2];
        System.arraycopy(s.toCharArray(), 0, sChars, 0, s.length());
        int count = 0;
        boolean inNumber = false;
        boolean previousInNumber = false;
        for (int i = 0; i < sChars.length - 2; i++) {
            inNumber = isDigit(sChars[i]);
            if (inNumber && (sChars[i + 1] == ',' || sChars[i + 1] == '.'))
                if (isDigit(sChars[i + 2]))
                    i += 2;
                else {
                    if (i + 2 == text.length())
                        count++;

                    inNumber = false;
                    i++;
                }
            if (previousInNumber && (!inNumber || i == s.length() - 1))
                count++;
            previousInNumber = inNumber;
        }

        return count;
    }

    private static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}