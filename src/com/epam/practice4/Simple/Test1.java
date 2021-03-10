package com.epam.practice4.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Piskunou Yury
 * @my.task 1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.
 * @since 03.02.21
 */
public class Test1 {
    static private int a;
    static private int b;

    static private void show() {
        System.out.printf("a = %d, b = %d\n", a, b);
    }

    static private void changeVariables() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter new value for a: ");
        a = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter new value for b: ");
        b = Integer.parseInt(bufferedReader.readLine());
    }

    static private int sum(int a, int b) {
        return a + b;
    }

    static private int max(int a, int b) {
        if (a >= b)
            return a;
        else return b;
    }

    public static void main(String[] args) throws IOException {
        a = 4;
        b = 7;
        char quit = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            show();
            System.out.println("a + b = " + sum(a, b));
            System.out.println("Max of a and b = " + max(a, b));
            System.out.println("Enter q - to quit: ");
            quit = (char) bufferedReader.read();
            if (quit == 'q')
                break;
            changeVariables();
        }
    }
}