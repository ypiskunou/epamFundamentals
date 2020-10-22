package com.epam.practice2.Array1D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 6.  Задана  последовательность  N  вещественных  чисел.
 * Вычислить  сумму  чисел,  порядковые  номера  которых являются простыми числами.
 * @since 21.10.20
 */
public class Task6 {

    public static void main(String[] args) {
        double[] array = new double[]{4, -2, 3, 0, 65, 36, -8, 2, 0};
        double sum = 0;
        for (int i = 0; i < array.length; i++)
            if (isPrime(i)) sum += array[i];

        System.out.printf("Original array %s\n", Arrays.toString(array));
        System.out.printf("Sum of numbers with prime indices: %.1f", sum);
    }

    private static boolean isPrime(int p) {

        if(p==2) return true;
        if (p % 2 == 0)
            return false;
        else
            for (int i = 3; i < Math.sqrt(p); i += 2)
                if (p % i == 0) return false;

        return true;
    }
}