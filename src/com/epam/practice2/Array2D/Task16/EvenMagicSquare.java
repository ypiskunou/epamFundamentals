package com.epam.practice2.Array2D.Task16;

public class EvenMagicSquare extends MagicSquare {

    private PermutationType[][] permutationTypes;
    private int k;
    private int m;
    private boolean onlyForHorizontalSymmetry;
    private boolean onlyForVerticalSymmetry;

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
        visualizePermutationArray();
    }

    private void buildMagicSquare() {
        if (n % 4 == 0) swapCentralSymetric();
        else {
            swapCentralSymetric();
            swapHorizontalSymetric();
            swapVerticalSymetric();
        }
    }

    private void getAdresses4x() {
        setCentralSymetric();
        completeByVerticalSymetry();
    }

    private void getAdresses2x() {
        setCentralSymetric();
        setVerticalSymetric();
        completeByVerticalSymetry();

        setHorizontalSymetric();
        completeByHorizontalSymetry();
    }

    private void setCentralSymetric() {
        int counter = 0;
        int start = 0; // if x2 -> then only value, though precondition on HV not diagonal makes it unnecessary
        int[] rowCounter = new int[m]; //     maybe
        int[] columnCounter = new int[m]; //        redundant
        for (int j = 0; j < m; j++, counter = 0) {
            for (int i = (start + j) % m; counter < k; i++, counter++) {
                int t = i % m;
                if (rowCounter[t] < k && columnCounter[j] < k)
                    permutationTypes[t][j].setCentralSymmetricPermutation(true);
                rowCounter[t]++;
                columnCounter[j]++;
            }
        }
    }

    private void setHorizontalSymetric() {
        int counter = 0;
        int start = k;
        int[] rowCounter = new int[m]; //     maybe
        int[] columnCounter = new int[m]; //        redundant
        for (int j = 0; j < m; j++, counter = 0) {
            for (int i = (start + j) % m; counter < 1; i++, counter++) {
                int t = i % m;
                if (rowCounter[t] < k && columnCounter[j] < k)
                    permutationTypes[t][j].setHorizontalSymmetricPermutation(true);
                rowCounter[t]++;
                columnCounter[j]++;
            }
        }
    }

    private void setVerticalSymetric() {
        int counter = 0;
        int start = k + 1;
        int[] rowCounter = new int[m]; //     maybe
        int[] columnCounter = new int[m]; //        redundant
        for (int j = 0; j < m; j++, counter = 0) {
            for (int i = (start + j) % m; counter < 1; i++, counter++) {
                int t = i % m;
                if (rowCounter[t] < k && columnCounter[j] < k)
                    permutationTypes[t][j].setVerticalSymmetricPermutation(true);
                rowCounter[t]++;
                columnCounter[j]++;
            }
        }
    }

    private void completeByVerticalSymetry() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (permutationTypes[i][j].isAnySymmetricPermutation())
                    permutationTypes[i][n - 1 - j] = permutationTypes[i][j];
    }

    private void completeByHorizontalSymetry() {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isCentralSymmetricPermutation() ||
                        permutationTypes[i][j].isHorizontalSymmetricPermutation())
                    permutationTypes[n - 1 - i][j] = permutationTypes[i][j];
    }

    private void swapCentralSymetric() {
        int temp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isCentralSymmetricPermutation()) {
                    temp = magicSquare[i][j];
                    magicSquare[i][j] = magicSquare[n - 1 - i][n - 1 - j];
                    magicSquare[n - 1 - i][n - 1 - j] = temp;
                }
        }
    }

    private void swapHorizontalSymetric() {
        int temp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isHorizontalSymmetricPermutation()) {
                    temp = magicSquare[i][j];
                    magicSquare[i][j] = magicSquare[n - 1 - i][j];
                    magicSquare[n - 1 - i][j] = temp;
                }
        }
    }

    private void swapVerticalSymetric() {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (permutationTypes[i][j].isVerticalSymmetricPermutation()) {
                    temp = magicSquare[i][j];
                    magicSquare[i][j] = magicSquare[i][n - 1 - j];
                    magicSquare[i][n - 1 - j] = temp;
                }
        }
    }

    private void visualizePermutationArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (permutationTypes[i][j].isCentralSymmetricPermutation())
                    System.out.print("*");
                else if (permutationTypes[i][j].isHorizontalSymmetricPermutation())
                    System.out.print("+");
                else if (permutationTypes[i][j].isVerticalSymmetricPermutation())
                    System.out.print("x");
                else System.out.print("_");
            System.out.println("\n");
        }
    }
}
