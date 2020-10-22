package com.epam.practice2.Array1D;

/**
 * @author Piskunou Yury
 * @since 21.10.20
 * @my.task 1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 * */
public class Task1 {

    public static void main(String[] args) {
        int[] array = new int[]{48, 23, 21, 65, 36, 8};
        int k=4;
        int sum = 0;
        for(int i = 0; i < array.length; i++)
            if(array[i]%k==0)
                sum+= array[i];
        System.out.printf("Sum of elements aliquot to %d is %d",k, sum);
    }
}