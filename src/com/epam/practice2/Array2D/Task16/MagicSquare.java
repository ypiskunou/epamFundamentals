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

public class MagicSquare {
    public int[][] getMagicSquare() {
        return magicSquare;
    }

    protected int[][] magicSquare; // get result from here whether it's odd or even

    int n;

    public MagicSquare(int n) {
        this.n = n;
        magicSquare = new int[n][n];
    }

    public int sum() {
        return (1 + n * n) * n / 2;
    }

    public boolean isMagicSquare() {
        int sum = 0;
        for (int i = 0; i < n; i++, sum = 0) {
            for (int j = 0; j < n; j++)
                sum += magicSquare[i][j];
            if (sum != sum()) return false;
        }

        for (int j = 0; j < n; j++, sum = 0) {
            for (int i = 0; i < n; i++)
                sum += magicSquare[i][j];
            if (sum != sum()) return false;
        }

        int backSum = 0;
        for (int i = 0; i < n; i++) {
            sum += magicSquare[i][i];
            backSum += magicSquare[i][n - 1 - i];
        }
        return sum == sum() && backSum == sum();
    }
}
