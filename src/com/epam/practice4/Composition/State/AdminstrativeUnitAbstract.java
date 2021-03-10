package com.epam.practice4.Composition.State;

abstract class AdminstrativeUnitAbstract {
    private String name;
    private int area;
    private int population;

    AdminstrativeUnitAbstract(String name, int area, int population) {
        this.name = name;
        this.area = area;
        this.population = population;
    }

    AdminstrativeUnitAbstract(String name){
        this.name = name;
        area = 0;
        population = 0;
    }

    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
