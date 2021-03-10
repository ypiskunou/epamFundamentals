package com.epam.practice4.Composition.State;

import java.util.HashMap;
import java.util.Map;

public class Region extends AdminstrativeUnitAbstract{
    private County county;
    private City capital;
    static private Map<City, Region> regionCities = new HashMap<>();

    public Region(String name, int area, int population, County county, City capital) {
        super(name, area, population);

        this.county = county;
        this.capital = capital;

        county.addRegion(this);
    }

    public Region(String name){
        super(name);
    }

    public Region addCity(City city){
        regionCities.put(city, this);
        return this;
    }

    public static City[] getRegionCities() {
        return regionCities.keySet().toArray(new City[regionCities.size()]);
    }

    public County getCounty() {
        return county;
    }

    public City getCapital() {
        return capital;
    }
}
