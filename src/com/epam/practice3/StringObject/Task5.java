package com.epam.practice3.StringObject;

/**
 * @author Piskunou Yury
 * @my.task 5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 * @since 09.01.21
 */

public class Task5 {

    public static void main(String[] args) {
        String informatica = "информатика";
        long countA = informatica.chars().filter(c -> c == 'а').count();
        System.out.println("The word " + informatica + " has " + countA + " entries. ");
    }
}
