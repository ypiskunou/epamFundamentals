package com.epam.practice2.Array2D.Task16;

import com.epam.practice2.Array2D.Task1;

import java.util.Scanner;

/**
 * @author Piskunou Yury
 * @my.task 16. Магическим квадратом порядка n называется квадратная матрица размера nxn,
 * составленная из чисел 1, 2, 3, ..., n^2 так, что суммы по каждому столбцу,
 * каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат
 * @since 03.11.20
 */
public class Task16 {

    public static void main(String[] args) {
        int n = 0;

        Scanner scanner = new Scanner(System.in);
        while (n < 3) {
            System.out.println("Enter matrix dimension: ");
            n = scanner.nextInt();
            scanner = new Scanner(System.in);
        }

        scanner.close();

        MagicSquare magicSquare;
        if (n % 2 == 0)
            magicSquare = new EvenMagicSquare(n);
        else
            magicSquare = new OddMagicSquare(n);

        System.out.printf("Magic square: \n%s", Task1.stringify2dArray(magicSquare.magicSquare));

        //EvenMagicSquare magicSquare = new EvenMagicSquare(4);
    }
}