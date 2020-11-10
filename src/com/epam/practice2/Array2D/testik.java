package com.epam.practice2.Array2D;

public class testik {
    public static void main(String[] args) {
        B b = new B(); // base child
    }
}

class A{
    B b;
    public A(){
        System.out.println(" base ");

        //b = new B(); // fail because of being recurrent
    }
}

class B extends A{
    public B(){
        System.out.println(" child ");
    }
}
