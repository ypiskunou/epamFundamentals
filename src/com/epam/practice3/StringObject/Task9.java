package com.epam.practice3.StringObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Piskunou Yury
 * @my.task 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
 * Учитывать только английские буквы.
 * @since 11.01.21
 */

public class Task9 {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter string to count letters and capitals: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        System.out.println("The given string is: " + text);

        long lettersCount = text.chars().filter(c -> c > 97 && c < 122).count();
        long capitalsCount = text.chars().filter(c -> c > 65 && c < 90).count();

        System.out.printf("The quantity of letters is %s and capitals is %s. ", lettersCount, capitalsCount);
    }
}