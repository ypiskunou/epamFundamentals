package com.epam.practice2.Array2D;

/**
 * @author Piskunou Yury
 * @my.task 2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 * @since 21.10.20
 */
public class Task2 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {4, -8, 3, 27},
                {7, 2, 4, 3},
                {8, 12, 4, 21},
                {2, 3, 1, 25}
        };

        for(int i=0;i<array.length;i++)
            for(int j=0;j<array[0].length;j++)
                if(i==j)
                    System.out.print(array[i][j]+" ");
    }
}