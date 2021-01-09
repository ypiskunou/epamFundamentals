package com.epam.practice2.Decomposition;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task  3. Вычислить  площадь  правильного  шестиугольника  со  стороной  а,
 * используя  метод  вычисления  площади треугольника.
 * @since 24.11.20
 */
public class Task3 {

    public static void main(String[] args) {

        double a = 5;

        System.out.printf("The area of the hexagon is %.2f. ", hexagonArea(a));
    }

    private static double equilateralTriangleArea(double a) {
        return 0.25*a*a*Math.tan(Math.toRadians(60));
    }
    private static double heronEquilateralTriangleArea(double a) {
        double p = 3./2*a;
        return Math.sqrt(1./8*p*a*a*a);
    }

    private static double hexagonArea(double a) {
        return 6*heronEquilateralTriangleArea(a);
    }
}