package com.epam.practice2.Decomposition;

/**
 * @author Piskunou Yury
 * @my.task 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой.
 * @since 24.11.20
 */
public class Task9 { // on precondition that it is a convex one

    public static void main(String[] args) {

        int x = 5;
        int y = 15;
        int z = 3;
        int t = 14;

        if (!isRectangle(x, y, z, t) || z + t < diagonal(x, y)) throw new IllegalArgumentException("Not a rectangle");

        System.out.printf("The area of the rectangle is %.2f. ", rectangleArea(x, y, z, t));
    }

    private static boolean isRectangle(int x, int y, int z, int t) {
        return x < y + z + t || y < x + z + t || z < x + y + t || t < x + y + z;
    }

    private static double diagonal(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

    private static double triangleArea(double a, double b, double c) {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static double rectangleArea(int x, int y, int z, int t) {
        return triangleArea(x, y, diagonal(x, y)) + triangleArea(z, t, diagonal(x, y));
    }
}