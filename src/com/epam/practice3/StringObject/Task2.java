package com.epam.practice3.StringObject;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 2. В строке вставить после каждого символа 'a' символ 'b'.
 * @since 09.01.21
 */

public class Task2 {
    private static String text = " One  small space    for a  man ,  one giant        space  for   a  mankind.  ";

    public static void main(String[] args) {
        System.out.println("Original text: " + text);
        System.out.println("The text with inserted 'b's after 'a's: " + inserTbAfteRa(text));
    }

    private static String inserTbAfteRa(String s) {
        String[] chuncks = s.split("a");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chuncks.length - 1; i++) {
            result.append(chuncks[i]);
            result.append("ab");
        }
        result.append(chuncks[chuncks.length - 1]);
        return result.toString();
    }
}
