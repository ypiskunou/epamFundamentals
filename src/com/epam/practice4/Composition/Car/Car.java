package com.epam.practice4.Composition.Car;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 * @since 09.01.21
 */

public class Car implements CombustionEngine {
    private Wheel[] wheels;
    private Engine engine;
    private String model;
    private int tank;
    private int fuel;
    private int year;
    private int speed;

    public Car(String model, int speed, int year) {
        this.model = model;
        this.speed = speed;
        this.year = year;
        wheels = new Wheel[4];
        engine = new Engine();
        tank = 30;
        fuel = tank / 2;
    }

    public void setWheels(Wheel[] wheels) {
        TireType type = wheels[0].getTire();
        if (Arrays.stream(wheels).allMatch(c -> c.getTire() == type))
            this.wheels = wheels;
        else throw new UnsupportedOperationException("All tires should be the same!");
    }

    public void drive() {
        System.out.println(model + " is driving. ");
        for (; fuel > tank / 10; fuel--) {
            try {
                Thread.sleep(166);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fillTank();
    }

    public void showTankLevel() {
        System.out.print("[");
        for (int i = 0; i < tank; i++) {
            if (i <= fuel)
                System.out.print("|");
            else System.out.print(" ");
        }
        System.out.println("]");
    }

    public void fillTank() {
        System.out.println(model + " is filling the tank. ");
        showTankLevel();
        System.out.print("[");
        for (int k = 0; k < fuel; k++)
            System.out.print("|");
        for (; fuel < tank; fuel++) {
            try {
                Thread.sleep(166);
                System.out.print("|");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("]");
    }

    public void modelEcho() {
        System.out.println(model + " by " + year + " with top speed of " + speed);
    }

    public static void main(String[] args) {
        Car car = new Car("Honda Civic", 180, 2005);
        car.modelEcho();
        car.fillTank();
        car.drive();
    }
}
