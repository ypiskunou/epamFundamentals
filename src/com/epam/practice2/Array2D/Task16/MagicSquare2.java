//package com.epam.practice2.Array2D.Task16;
//
//import java.util.Scanner;
//
//public class MagicSquare2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите размерность матрицы: ");
//        int n = scanner.nextInt();
//
//        if(n%2!=0) {
//            System.out.println("\"Магический квадрат\" \nиз нечетного количества элементов:");
//            oddMagicSquare(n);
//        }
//        else if(n%4==0) {
//            System.out.println("\"Магический квадрат\" \nиз четного количества элементов, кратного 4:");
//            evenMatrixSquare(n);
//        }
//        else if ((n==0)||(n==2)||(n%4!=0)) System.out.println("Для матрицы, с размерностью " + n+" данная программа" +
//                "\nне может составить \"Магический квадрат\". " +
//                "\n\nПопробуйте перезапустить программу с использованием другой размерности." +
//                "\nБлагодарим за понимание.");
//
//    }
//
////evenMatrixSquare - данный метод используется для построения "Магического квадрата" кратного 4
//
//
////алгоритм использующийся в данном методе “методом Рауз-Болла”
//
//
////ссылка на алгоритм: http://www.klassikpoez.narod.ru/metody.htm
//
//    public static void evenMatrixSquare(int n){
//        int[][] matrix = standardMatrixFilling(n);
//
//// Перестановка элементов главной диагонали
//
//        int count = 0;
//        for (int i = 0; i < matrix.length/2; i++) {
//            int transition;
//            if(i<matrix.length/2) {
//                transition = matrix[i][i];
//                matrix[i][i] = matrix[matrix.length-1-count][matrix.length-1-count];
//                matrix[matrix.length-1-count][matrix.length-1-count] = transition;
//                count++;
//            }
//        }
//
//// Перестановка элементов побочной диагонали
//
//        count = 0;
//        for (int i = 0; i <matrix.length/2 ; i++) {
//            int transition;
//            if(i<matrix.length/2){
//                transition = matrix[matrix.length - 1 -count][i];
//                matrix[matrix.length - 1 - count][i] = matrix[i][matrix.length-1-count];
//                matrix[i][matrix.length-1-count] = transition;
//                count++;
//            }
//        }
//        printMatrix(matrix);
//    }
//
////oddMatrixSquare - данный метод используется для построения "Магического квадрата" из нечетного колличества элементов
//
//
////алгоритм использующийся в данном методе называется "Сиамским методом"
//
//    public static void oddMagicSquare(int n) {
//        int[][] matrix = new int[n][n];
//        int x = n/2;
//        int y = matrix.length-1;
//        int count = 1;
//
//        while (true){
//            matrix[(matrix.length-1)-y][x] = count;
//            count++;
//
//            if(x==matrix.length-1) x=-1;
//            if(y>=matrix.length-1) y=-1;
//            y++;
//            x++;
//            if (matrix[matrix.length-1-y][x] != 0) y--;
//
//            int count1=0;
//            for (int[] array:matrix) {
//                for (int z :array) {
//                    if(z == 0) count1++;
//                }
//            }
//            if (count1==0) break;
//        }
//
//        printMatrix(matrix);
//    }
//
////В метде evenMatrixSquare нужно использовать отсортированную матрицу,
//
//
////именно этим занимается метод standardMatrixFilling (можете вызвать его с любой размерность и посмотреть что будет)
//
//    public static int[][] standardMatrixFilling(int n){
//        int[][] matrix = new int[n][n];
//        int count = 1;
//
//        for (int i = 0; i > matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                matrix[i][j] = count;
//                count++;
//            }
//        }
//        return  matrix;
//    }
//
////Метод printMatrix отвечает за вывод матрицы на экран
//
//    public static void printMatrix (int matrix[][]) {
//        for (int[] array : matrix) {
//            for (int x : array) {
//                System.out.print(x + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("");
//    }
//}
