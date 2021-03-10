package com.epam.practice4.Composition.Car;

enum EngineType{
    DIESEL,
    GAS
}

public class Engine {
    private double volume;
    private EngineType engineType;

    public Engine(double volume, EngineType engineType) {
        this.volume = volume;
        this.engineType = engineType;
    }

    public Engine() {
        volume = 2.0;
        engineType = EngineType.DIESEL;
    }
}
