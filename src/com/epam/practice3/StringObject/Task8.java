package com.epam.practice3.StringObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Piskunou Yury
 * @my.task 8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 * @since 11.01.21
 */

public class Task8 {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter string separated by spaces to find max length word: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        System.out.println("The given string is: " + text);

        String longestWord = Arrays.stream(text.split(" ")).
                max(Comparator.comparing(String::length)).orElse(null);

        System.out.println("The longest word in given string is " +
                (longestWord == null ? "not defined" : longestWord));
    }
}
