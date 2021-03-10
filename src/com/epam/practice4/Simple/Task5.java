package com.epam.practice4.Simple;

/**
 * @author Piskunou Yury
 * @my.task 5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать
 * свое значение на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию
 * и произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния,
 * и  метод позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 * @since 07.02.21
 */

class Counter {

    private int min, max, current;

    public Counter(int min, int max, int current) {

        if (max < min) {
            int tmp = max;
            max = min;
            min = tmp;

        if (current < min)
            current = min;
        if (current > max)
            current = max;
        }

        this.min = min;
        this.max = max;
        this.current = current;
    }

    public Counter(int min, int max){
        this(min, max, min);
        
    }

    public Counter(){
        this(0, 7, 1);
    }

    public void increment(){
        current++;
        if(current> max)
            current = min;
    }

    public void decrement(){
        current--;
        if(current < min)
            current = max;
    }

    public int value(){
        return current;
    }

    public static void main(String[] args) {

        Counter a = new Counter();
        Counter b = new Counter(18, 3, 2);
        Counter c = new Counter(10, 3, 14);

        System.out.println("a: " + a.value());
        System.out.println("b: " + b.value());
        System.out.println("c: " + c.value());
        System.out.println("\n");

        for(int i = 0; i < 8; i++){
            a.increment();
            b.decrement();
            c.increment();
        }

        System.out.println("After increment on 8");
        System.out.println("a: " + a.value());
        System.out.println("c: " + c.value());
        System.out.println("After decrement on 8");
        System.out.println("b: " + b.value());
    }
}
