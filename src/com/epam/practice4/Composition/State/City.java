package com.epam.practice4.Composition.State;

public class City extends AdminstrativeUnitAbstract{

    private Region region;

    public City(String name, int area, int population, Region region) {
        super(name, area, population);
        this.region = region;
        region.addCity(this);
    }

    public City(String name){
        super(name, 0, 0);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Region getRegion() {
        return region;
    }

    public void addToRegion(Region region) {
        this.region = region;
        region.addCity(this);
    }
}
