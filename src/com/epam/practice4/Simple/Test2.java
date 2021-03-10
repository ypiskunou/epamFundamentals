package com.epam.practice4.Simple;

/**
 * @author Piskunou Yury
 * @my.task 2.  Создйте  класс  Test2  двумя  переменными.  Добавьте  конструктор  с  входными  параметрами.  Добавьте
 * конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
 * класса.
 * @since 03.02.21
 */
public class Test2 {
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    private int a;
    private int b;

    public Test2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Test2() {
        a = 0;
        b = 0;
    }

    private void show() {
        System.out.println("a = " + getA());
        System.out.println("b = " + getB());
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.show();
        test2.setA(5);
        test2.setB(4);
        test2.show();
        Test2 preset = new Test2(2, 3);
        preset.show();
    }
}