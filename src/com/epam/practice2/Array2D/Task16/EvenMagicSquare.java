package com.epam.practice2.Array2D.Task16;

public class EvenMagicSquare extends MagicSquare {

    public EvenMagicSquare(int n) {
        super(n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                magicSquare[i][j] = i * n + j + 1;
    }

    public void swapCentralSymetric(int[] adresses) {
        int temp;
        int i;
        int j;
        for (int adress : adresses) {
            j = adress % n;
            i = (adress - j) / n;
            temp = magicSquare[i][j];
            magicSquare[i][j] = magicSquare[n - 1 - i][n - 1 - j];
            magicSquare[n - 1 - i][n - 1 - j] = temp;
        }
    }

    public void swapCentralRowSymetric(int[] adresses) {
        int temp;
        int i;
        int j;
        for (int adress : adresses) {
            j = adress % n;
            i = (adress - j) / n;
            temp = magicSquare[i][j];
            magicSquare[i][j] = magicSquare[n - 1 - i][j];
            magicSquare[n - 1 - i][j] = temp;
        }
    }

    public void swapCentralColumnSymetric(int[] adresses) {
        int temp;
        int i;
        int j;
        for (int adress : adresses) {
            j = adress % n;
            i = (adress - j) / n;
            temp = magicSquare[i][j];
            magicSquare[i][j] = magicSquare[i][n - 1 - j];
            magicSquare[i][n - 1 - j] = temp;
        }
    }
}
