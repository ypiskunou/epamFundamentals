package com.epam.practice3.StringObject;

/**
 * @author Piskunou Yury
 * @my.task 4. С помощью функции копирования и операции конкатенации
 * составить из частей слова “информатика” слово “торт”.
 * @since 09.01.21
 */

public class Task4 {

    public static void main(String[] args) {
        String informatica = "информатика";
        String t = informatica.substring(informatica.indexOf('т'), informatica.indexOf('т') + 1);
        String or = informatica.substring(3, 5);
        String tort = "";
        tort = tort.concat(t).concat(or).concat(t);
        System.out.println("The resulting word after concatination is " + tort);
    }
}
