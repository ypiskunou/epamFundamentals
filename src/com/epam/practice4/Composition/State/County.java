package com.epam.practice4.Composition.State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class County extends AdminstrativeUnitAbstract{
    private State state;
    private City capital;
    static private Map<Region, County> regions = new HashMap<>();

    public County(String name, int area, int population, State state, City capital) {
        super(name, area, population);
        this.state = state;
        this.capital = capital;
        state.addCounty(this);
    }

    public County(String name){
        super(name);
    }

    public City getCapital() {
        return capital;
    }

    public Region[] getRegions() {
        return regions.keySet().toArray(new Region[regions.size()]);
    }

    public Region getRegionByName(String name){
        return Arrays.stream(getRegions()).filter(c -> c.getName().equals(name)).findAny().get();
    }

    static public Region getRegionByNameStatic(String name){
        return Arrays.stream(regions.keySet().toArray(new Region[regions.size()])).filter(c -> c.getName().equals(name)).findAny().get();
    }

    public County addRegion(Region region) {
        regions.put(region, this);
        return this;
    }
}
