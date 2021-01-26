package com.epam.practice3.StringObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author Piskunou Yury
 * @my.task 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 * @since 09.01.21
 */

public class Task7 {

    public static void main(String[] args) throws IOException {
        //String text = "abc cde def";
        System.out.println("Enter string to get a unique set of characters: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        System.out.println("The given string is: " + text);
        StringBuilder result = new StringBuilder(" ");
        result.append(text);

        HashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < result.length(); i++) {
            linkedHashSet.add(result.charAt(i));
        }

        result = new StringBuilder();
        for (Character c : linkedHashSet) {
            result.append(c);
        }

        text = result.toString().trim();

        System.out.println("The result of transforming into set without spaces: " + text);
    }
}
