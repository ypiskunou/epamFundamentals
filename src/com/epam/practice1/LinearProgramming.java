package com.epam.practice1;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class LinearProgramming {
    private static double a;
    private static double b;
    private static double c;
    private static double d;

    private static double x;
    private static double y;

    static  {
        a = 3;
        b = 4;
        c = 5;
        d = 1;
        x = 7;
        y = 2;
    }

    public static void main(String[] args) throws IOException {
        System.out.printf("\n/*************** linear ****************/\n" +
                        "1. z= %.0f\n" +
                        "2. expression equals %.2f\n" +
                        "3. trigonometric: %.2f\n" +
                        "4. swapped xxx.yyy: %.3f\n" +
                        "5. hh mm ss: %s\n" +
                        "6. Point (5,1) is %s in the region\n" +
                        "\n/*************** if/else ****************/\n" +
                        "1. %s\n" +
                        "2. max out of mins: %.2f\n" +
                        "3. Points A(1,2), B(5,1) and C(2,3) are %s at the same line\n" +
                        "4. Given brick 7x2x4 does %s fits hole of 3x4\n" +
                        "5. Calculated expression is: %.4f\n" +
                        "\n/*************** loops ****************/\n" +
                        "1. Sum of arithmetic progression: %d\n" +
                        "2. Value calculated at the interval: y = %s\n" +
                        "3. Sum of squares from 1 to 100: %d\n" +
                        "4. Product of squares from 1 to 200: %.0f\n" +
                        "5. Sum of 1/2^k+1/3^k with constraint e = 0.00045, n = 45: %.2f\n" +
                        "6. Table of ASCII: \n%s\n" +
                        "7. Table of dividers. %s\n" +
                        "8. Set of the same numbers at 1234577 31556: %s",
                function1(),
                function2(),
                function3(),
                swapIntegersDecimals(),
                getTimeHmsOutOfSeconds(7265),
                isPointInRegion(new Point(5,1))?"":"not",
                checkIfTriangleOnAngles(125,65),
                max(min(a, b), min(c, d)),
                isPointsOnLine(new Point(1,2), new Point(5,1), new Point(2,3))?"":"not",
                isBrickInPattern(new Brick(7,2,4),
                        new Rectangle(3,4))?"":"not",
                calculateExpression(),
                sumOfArithmeticProgression(),
                getAllValuesWithStep(0.2),
                sumOfSquaresFor100(),
                productOfSquaresFor200(),
                sumWithConstraint(45,0.00045),
                tableAscii(),
                getAllDividers(14, 47),
                setOfNumbers(123450, 31550));
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

    private static double swapIntegersDecimals() throws IOException {
        String toSwap;
        Matcher matcher;
        BufferedReader br;
        do {
            System.out.println("Enter number in format xxx.yyy to get its reverse...");
            br = new BufferedReader(new InputStreamReader(System.in));
            toSwap = br.readLine();
            String pattern = "^[0-9]{3}\\.[0-9]{3}$";
            Pattern numberPattern = Pattern.compile(pattern);
            matcher = numberPattern.matcher(toSwap);
        } while (!matcher.matches());

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
    private static String checkIfTriangleOnAngles(int a, int b) {
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

    private static int sumOfArithmeticProgression() throws IOException {
        int endpoint;
        BufferedReader br;
        do {
            System.out.println("Enter positive integer greater than 1: ");

            br = new BufferedReader(new InputStreamReader(System.in));
            endpoint = Integer.parseInt(br.readLine());
        } while (endpoint < 2);
        br.close();

        return (1+endpoint)*endpoint/2;
    }

    private static String getAllValuesWithStep(double h){
        StringBuilder resultArray = new StringBuilder();
        for(double x=a;x<=b;x+=h){
            if (x > 2) {
                resultArray.append(x+"\t");
            } else {
                resultArray.append(-x+"\t");
            }
        }
        return resultArray.toString();
    }

    private static int sumOfSquaresFor100(){
        int sum = 0;
        for(int i=1;i<=100;i++)
            sum+= i*i;
        return sum;
    }

    private static BigDecimal productOfSquaresFor200(){
        BigDecimal product = new BigDecimal(1);
        for(int i=1;i <= 200;i++)
            product = product.multiply(new BigDecimal(i*i));
        return product;
    }

    private static double sumWithConstraint(int n, double e) {
        double sum = 0;
        double temp;
        for (int i = 1; i <= n; i++) {
            temp = pow(0.5, -i) + pow(1 / 3.0, -i);
            if (temp >= e)
                sum += pow(0.5, -i) + pow(1 / 3.0, -i);
            else
                return sum;
        }
        return sum;
    }

    private static String tableAscii(){
        StringBuilder table = new StringBuilder();
        for(int k = 0; k<256; k++) {
            table.append((char) k + "-> " + k + "\t");
            if(k%16==0)
                table.append("\n");
        }

        return table.toString();
    }

    private static String getAllDividers(int m, int n){
        StringBuilder header = new StringBuilder("Output of dividers between "+m+" and "+n+"\n");
        StringBuilder body = new StringBuilder();
        for(int i = m; i <= n; i++){
            body.append("For "+i+": ");
            for(int l:getDividers(i))
                body.append(l+", ");
            body.append("\b\b;\n");
        }

        return header.append(body).toString();
    }

    private static ArrayList<Integer> getDividers(int d){
        ArrayList<Integer> dividersList = new ArrayList<>();
        for(int i = 2; i <= d/2; i++)
            if(d%i==0)
                dividersList.add(i);

        return dividersList;
    }

    private static String setOfNumbers(double p, double q){
        String temp = String.valueOf(p);
        String firstNumber = temp.replaceAll("[,.]|0*$","");

        temp = String.valueOf(q);
        String secondNumber = temp.replaceAll("[,.]|0*$","");

        Character[] firstSequence = IntStream.range(0, firstNumber.toCharArray().length)
                .mapToObj(i -> firstNumber.toCharArray()[i])
                .toArray(Character[]::new);

        Character[] secondSequence = IntStream.range(0, secondNumber.toCharArray().length)
                .mapToObj(i -> secondNumber.toCharArray()[i])
                .toArray(Character[]::new);

        List<Character> firstUniques = Arrays.asList(firstSequence).stream()
                .distinct()
                .collect(Collectors.toList());

        List<Character> secondUniques = Arrays.asList(secondSequence).stream()
                .distinct()
                .collect(Collectors.toList());

        List<Character> commonList = new ArrayList<>();
        commonList.addAll(firstUniques);
        commonList.addAll(secondUniques);

        List<Character> sameNumbers = commonList.stream()
                .filter(i->Collections.frequency(commonList, i) > 1)
                .distinct()
                .collect(Collectors.toList());
        return sameNumbers.toString();
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
