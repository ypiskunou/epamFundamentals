package com.epam.practice1;

import java.awt.*;
import java.time.Duration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class LinearProgramming {
    private static double a;
    private static double b;
    private static double c;
    private static double d;

    private static double x;
    private static double y;
    private static double z;

    static  {
        a = 3;
        b = 4;
        c = 5;
        d = 1;
        x = 7;
        y = 2;
        z = 4;
    }

    public static void main(String[] args) {
        System.out.printf("\n/*************** linear ****************/\n" +
                        "1. z= %.0f\n" +
                        "2. expression equals %.2f\n" +
                        "3. trigonometric: %.2f\n" +
                        "4. swapped xxx.yyy: %.3f\n" +
                        "5. hh mm ss: %s\n" +
                        "6. Point (5,1) is %s in the region\n" +
                        "\n/*************** if/else ****************/\n" +
                        "1. %s\n" +
                        "2. max out of min: %.2f\n" +
                        "3. Points A(1,2), B(5,1) and C(2,3) are %s at the same line\n" +
                        "4. Given brick 7x2x4 does %s fits hole of 3x4\n" +
                        "5. Calculated expression is: %.4f\n" +
                        "\n/*************** loops ****************/\n" +
                        "1. Sum of arithmetic progression: %d\n",
                function1(),
                function2(),
                function3(),
                swapIntegersDecimals(),
                getTimeHmsOutOfSeconds(7265),
                isPointInRegion(new Point(5,1))?"":"not",
                tellIfTriangleOnAngles(125,65),
                max(min(a, b), min(c, d)),
                isPointsOnLine(new Point(1,2), new Point(5,1), new Point(2,3))?"":"not",
                isBrickInPattern(new Brick(7,2,4),
                        new Rectangle(3,4))?"":"not",
                calculateExpression(),
                sumOfArithmeticProgression());
    }

    //region linear
    private static double function1() throws ArithmeticException{
        return  (a - 3 ) * b / 2 + c;
    }

    private static double function2() throws ArithmeticException{
        return  (b + sqrt(pow(b,2)+4*a*c))/(2*a)+pow(a,3)+pow(b,-2);
    }

    private static double function3() throws ArithmeticException{
        return  (sin(x)+cos(y))/(cos(x)-sin(y))*tan(x*y);
    }

    private static double swapIntegersDecimals(){
        String toSwap;
        Matcher matcher;
        Scanner scanner;
        do {
            System.out.println("Enter number in format xxx.yyy to get its reverse...");
            scanner = new Scanner(System.in);
            double r = Double.parseDouble(scanner.nextLine());
            toSwap = String.valueOf(r);
            String pattern = "^[0-9]{3}\\.[0-9]{3}$";
            Pattern numberPattern = Pattern.compile(pattern);
            matcher = numberPattern.matcher(toSwap);
        } while (!matcher.matches());
        scanner.reset();
        scanner.close();

        String[] integersDecimals = toSwap.split("\\.");
        StringBuilder decimalsIntegers = new StringBuilder(integersDecimals[1]);
        decimalsIntegers.append('.').append(integersDecimals[0]);

        return Double.parseDouble(decimalsIntegers.toString());
    }

    private static String getTimeHmsOutOfSeconds(int t){
        Duration duration = Duration.ofSeconds(t);

        return String.format("%dч %dмин %dс", duration.toHours(),
                duration.toMinutes()-duration.toHours()*60, t-duration.toMinutes()*60);
    }

    private static boolean isInRectangle(Rectangle rectangle, Point point){
        return rectangle.xLeft<point.x && rectangle.xRight>point.x &&
                rectangle.yBottom<point.y && rectangle.yUpper>point.y;
    }

    private static boolean isPointInRegion(Point point){
        Rectangle upperRectangle = new Rectangle(-2,2,0,4);
        Rectangle bottomRectangle = new Rectangle(-4,4,-3,0);

        return isInRectangle(upperRectangle, point)||isInRectangle(bottomRectangle, point);
    }
    //endregion

    //region if/else
    private static String tellIfTriangleOnAngles(int a, int b) {
        StringBuilder result = new StringBuilder();
        if (a + b < 180) {
            result.append("It is a triangle. ");
            if (a == 90 || b == 90 || a + b == 90)
                result.append("And given triangle is rectangular");
        } else result.append("This is not a triangle");
        return result.toString();
    }

    private static double min(double a, double b)
    {
        if(a<b)
            return a;
        else return b;
    }
    private static double max(double a, double b){
        return -min(-a,-b);
    }

    private static boolean isPointsOnLine(Point a, Point b, Point c){
        return (b.x-a.x)/((double)(b.y-a.y))==(c.x-b.x)/((double)(c.y-b.y)) &&
                (c.x-b.x)/((double)(c.y-b.y))==(c.x-a.x)/((double)(c.y-a.y));
    }

    private static boolean isBrickInPattern(Brick brick, Rectangle pattern){
        return (pattern.xRight-pattern.xLeft >= brick.minSize()) &&
                (pattern.yUpper-pattern.yBottom >= brick.middleSize()) ||
                        (pattern.xRight-pattern.xLeft >= brick.middleSize()) &&
                (pattern.yUpper-pattern.yBottom >= brick.minSize());
    }

    private static double calculateExpression(){
        if(x>3)
            return 1.0/(pow(x,3)+6);
        else return pow(x,2)-3*x+9;
    }

    //endregion

    //region loops

    private static int sumOfArithmeticProgression(){
        int endpoint;
        Scanner scanner = new Scanner(System.in);;
        do {
            System.out.println("Enter positive integer greater than 1: ");
            endpoint = scanner.nextInt();
            scanner.reset();
        } while (endpoint < 2);
        scanner.close();

        return (1+endpoint)*endpoint/2;
    }

    //endregion
}

class Rectangle{
    int xLeft;
    int xRight;
    int yBottom;
    int yUpper;

    public Rectangle(int xLeft, int xRight, int yBottom, int yUpper) {
        this.xLeft = xLeft;
        this.xRight = xRight;
        this.yBottom = yBottom;
        this.yUpper = yUpper;
    }
    public Rectangle(int xRight, int yUpper) {
        this.xLeft = 0;
        this.xRight = xRight;
        this.yBottom = 0;
        this.yUpper = yUpper;
    }
}

class Brick{
    int height;
    int width;
    int depth;

    public Brick(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    public int minSize(){
        return min(height, min(width, depth));
    }

    public int middleSize(){
        return height+width+depth-minSize()-max(height, max(width, depth));
    }
}
