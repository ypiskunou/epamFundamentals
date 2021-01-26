package com.epam.practice3.StringObject;

/**
 * @author Piskunou Yury
 * @my.task 6. Из заданной строки получить новую, повторив каждый символ дважды.
 * @since 09.01.21
 */

public class Task6 {

    public static void main(String[] args) {
        String informatica = "информатика";
        StringBuilder result = new StringBuilder();
        //long countA = informatica.chars().forEach();
        for(int i = 0; i < informatica.length(); i++)
            result.append(informatica.charAt(i)).append(informatica.charAt(i));
        System.out.println("The result of doubled letters is: " + result);
    }
}
