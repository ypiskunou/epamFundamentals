package com.epam.practice3.StringObject;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 * @since 09.01.21
 */

public class Task1 {
    private static String text = " One  small space    for a  man ,  one giant        space  for   a  mankind.  ";

    public static void main(String[] args) {
        System.out.println("The longest sequence of spaces has a length of " + countSpacesInRow(text));
    }

    private static int countSpacesInRow(String s) {
        String[] spaces = s.split("\\S");
        return Arrays.stream(spaces).map(String::length).max(Integer::compareTo).get();
    }
}