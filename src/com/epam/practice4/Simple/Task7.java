package com.epam.practice4.Simple;

/**
 * @author Piskunou Yury
 * @my.task 7. Описать класс, представляющий треугольник.
 * Предусмотреть методы для создания объектов, вычисления площади, периметра и точки пересечения медиан.
 * @since 07.02.21
 */

class Triangle {

    int a;
    int b;
    int c;

    public Triangle(int _a, int _b, int _c) {
        if (_a <= 0 || _b <= 0 || _c <= 0)
            throw new IllegalArgumentException("Any side must have positive length! ");
        if (_a >= _b + _c || _b >= _a + _c || _c >= _a + _b)
            throw new IllegalArgumentException("Any side must be smaller than sum of two others! ");
        a = _a;
        b = _b;
        c = _c;
    }

    @Override
    public String toString() {
        return "side A: " + a + ", side B: " + b + ", side C: " + c;
    }

    private int getTrianglePerimeter() {
        return a + b + c;
    }

    private double getTriangleArea() {
        double p = getTrianglePerimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private double getMedianCenterFromA() {
        return 1 / 6.0 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
    }

    public static void main(String[] args) {

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println("Triangle is: \n" + triangle);
        System.out.println("It's perimeter: " + triangle.getTrianglePerimeter());
        System.out.println("Area: " + triangle.getTriangleArea());
        System.out.printf("The center of mass is %.3f from side A\n", triangle.getMedianCenterFromA());
    }
}
