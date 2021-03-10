package com.epam.practice4.Composition.Car;

enum TireType {
    SUMMER,
    WINTER
}

public class Wheel {

    private int diamter = 25;
    private TireType tire;

    public int getDiamter() {
        return diamter;
    }

    public TireType getTire() {
        return tire;
    }

    public Wheel(int diamter, TireType tire) {
        this.diamter = diamter;
        this.tire = tire;
    }

    public Wheel() {
        diamter = 21;
        tire = TireType.SUMMER;
    }
}
