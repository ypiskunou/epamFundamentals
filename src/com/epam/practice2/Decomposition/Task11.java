package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 * @since 24.11.20
 */
public class Task11 {

    public static void main(String[] args) {

        double number1 = 1234789;
        double number2 = -1234.789;

        //System.out.printf("The number %d is bigger. ", compareNumbers(number1, number2));
        System.out.printf(compareNumbers(number1, number2) == 0 ? "The number of digits is equal" :
                "The number of digits in %d is bigger. ", compareNumbers(number1, number2));
    }

    private static int numberOfDigits(double n) {
        String numberString = Double.toString(n).replaceAll("\\.0$|,|\\.|-", "");

        return numberString.length();
    }

    private static int compareNumbers(double number1, double number2) {
        if (numberOfDigits(number1) > numberOfDigits(number2))
            return 1;
        else if (numberOfDigits(number2) > numberOfDigits(number1))
            return 2;
        else return 0;
    }
}