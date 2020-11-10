package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 7. Сформировать квадратную матрицу порядка N по правилу:  A[I,J]=sin((I^2-J^2)/N)
 * и подсчитать количество положительных элементов в ней.
 * @since 21.10.20
 */
public class Task7 {

    public static void main(String[] args) {
        final int N = 8;
        double[][] array = new double[N][N];

        int positives = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                array[i][j] = Math.round(Math.sin((i * i - j * j) / N) * 100) / 100.0;
                if (array[i][j] > 0) positives++;
            }

        System.out.printf("Resulting matrix: \n%s", Task1.stringify2dArray(array));
        System.out.printf("\nQuantity of positives: %d", positives);
    }
}