package com.epam.practice3.StringObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piskunou Yury
 * @my.task 10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
 * восклицательным или вопросительным знаком. Определить количество предложений в строке X.
 * @since 11.01.21
 */

public class Task10 {

    public static void main(String[] args) {
        String X = "Row X consists of several... proposals! " +
                "Each is separated by dot, proclamation... or interrogative. Oh? Really? ";
        System.out.println("The given string is: " + X);

        Pattern pattern = Pattern.compile("\\.\\.\\.");
        int dots3 = 0;
        Matcher matcher = pattern.matcher(X);
        while (matcher.find())
            dots3++;

        long proposalsCount = X.chars().filter(c -> c == '!' || c == '.' || c == '?').count();

        System.out.printf("The quantity of proposals is %s. ", proposalsCount - dots3*3);
    }
}