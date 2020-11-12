package com.epam.practice2.Array2D.Task16;

public class EvenMagicSquare extends MagicSquare {

    private PermutationType[][] permutationTypes;
    private int k;
    private int m;

    public EvenMagicSquare(int n) {
        super(n);
        permutationTypes = new PermutationType[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                magicSquare[i][j] = i * n + j + 1;
                permutationTypes[i][j] = new PermutationType();
            }

        m = n / 2;
        if (n % 4 == 0) {
            k = m / 2;
            getAdresses4x();
        } else {
            k = (m - 1) / 2;
            getAdresses2x();
        }

        buildMagicSquare();
        visualizePermutationArrayUpperHalf();
    }

    private void buildMagicSquare() {
        swapCentralSymetric();
    }

    private void getAdresses4x() {
        int counter = 0;
        int start = 1;
        int[] rowCounter = new int[m];
        int[] columnCounter = new int[m];
        for (int j = 0; j < m; j++, counter = 0) {
            for (int i = (start + j)%m; counter < k; i++, counter++) {
                int t = i%m;
                if (rowCounter[t] < k && columnCounter[j] < k)
                    permutationTypes[t][j].setA(true);
                rowCounter[t]++;
                columnCounter[j]++;
            }
        }
        completeByVerticalymetry();
    }

    private void visualizePermutationArrayUpperHalf() {
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isA())
                    System.out.print("*");
                else System.out.print("_");
            System.out.println("\n");
        }
    }

    private void getAdresses2x() {

    }

    private void completeByVerticalymetry() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isAny())
                    permutationTypes[i][n - 1 - j] = permutationTypes[i][j];
    }

    private void swapCentralSymetric() {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isA()) {
                    temp = magicSquare[i][j];
                    magicSquare[i][j] = magicSquare[n - 1 - i][n - 1 - j];
                    magicSquare[n - 1 - i][n - 1 - j] = temp;
                }
        }
    }
}
