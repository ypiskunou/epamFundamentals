package com.epam.practice3.CharArray;

import java.util.regex.Pattern;

/**
 * @author Piskunou Yury
 * @my.task 5.  Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 * @since 07.01.21
 */
public class Task5 {
    private static String text = " It's  one    small space  for a  man ,  but large       space  for a  mankind.  ";

    public static void main(String[] args) {

        System.out.println("The original text is: " + text);
        text = cleanRedundantSpaces(text);
        System.out.println("The text without redundant spaces: " + text);
    }

    private static String cleanRedundantSpaces(String s) {
        char[] sChars = s.toCharArray();
        char[] temp = new char[s.length()];

        int count = 0;
        int i = 0;
        int upperBound = s.length() - 1;
        while (sChars[i] == ' ')
            i++;
        while (sChars[upperBound] == ' ')
            upperBound--;
        if (i == 0) i++;
        Pattern pattern = Pattern.compile("\\p{Punct}");

        for (int j = 0; i <= upperBound; i++) {
            if (sChars[i - 1] == ' ' && sChars[i] == ' ')
                continue;
            String source = new String(new char[]{sChars[i]});
            if (pattern.matcher(source).matches() && sChars[i - 1] == ' ') {
                temp[j] = sChars[i];
                swap(temp, j - 1, j);
                swap(sChars, i - 1, i);
                j++;
                count++;
                continue;
            }

            temp[j++] = sChars[i];
            count++;
        }

        char[] result = new char[count];
        for (int j = 0; j < count; j++)
            result[j] = temp[j];

        return new String(result);
    }

    private static void swap(char[] source, int a, int b) {
        char temp = source[a];
        source[a] = source[b];
        source[b] = temp;
    }
}