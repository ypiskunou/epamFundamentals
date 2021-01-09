package com.epam.practice2.Decomposition;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 12.  Даны  натуральные  числа  К  и  N.
 * Написать  метод(методы)  формирования  массива  А,  элементами  которого являются числа,
 * сумма цифр которых равна К и которые не большее N.
 * @since 16.12.20
 */
public class Task12 {

    private static int k = 12;
    private static int n = 1840;

    public static void main(String[] args) {

        //System.out.printf("The number %d is bigger. ", compareNumbers(number1, number2));
        System.out.printf("Set of numbers with sum of digits equal to %d and not greater than %d: ", k, n);
        System.out.println(Arrays.toString(setOfDigits()));
    }

    private static int[] arrayOfDigits(int n) {
        char[] numberString = Integer.toString(n).toCharArray();
        int[] digits = new int[numberString.length];
        for (int i = 0; i < numberString.length; i++)
            digits[i] = (int) numberString[i] - 48;

        return digits;
    }

    private static int sumOfDigits(int n) {
        int[] number = arrayOfDigits(n);
        int sum = 0;
        for (int i = 0; i < number.length; i++)
            sum += number[i];

        return sum;
    }

    private static int[] setOfDigits() {
        int[] digitsOfN = arrayOfDigits(n);
        int length = digitsOfN.length;
        if (k / length > 9) throw new IllegalArgumentException("Too big sum of digits for this little number");

        int[] setOfNumbers = new int[n];
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            if(sumOfDigits(i) == k)
                setOfNumbers[counter++] = i;
        }

        int[] resultingSet = new int[counter];
        for(int i = 0, j = 0; i < counter; i++)
            if(setOfNumbers[i]!=0)
                resultingSet[j++] = setOfNumbers[i];

        return resultingSet;
    }
}