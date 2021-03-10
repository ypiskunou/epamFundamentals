package com.epam.practice4.Composition.State;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Piskunou Yury
 * @my.task 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 * @since 09.01.21
 */

public class State extends AdminstrativeUnitAbstract {
    private City capital;
    private Map<County, State> counties = new HashMap<>();

    State(String name, int area, int population, City capital) {
        super(name, area, population);
        this.capital = capital;
    }

    public void updateArea() {
        int totalArea = 0;
        County[] allCounties = getCounties();
        for (County county :
                allCounties) {
            totalArea += county.getArea();
        }
        setArea(totalArea);
    }

    public County[] getCounties() {
        return counties.keySet().toArray(new County[counties.size()]);
    }

    public County getCountyByName(String name){
        return Arrays.stream(getCounties()).filter(c -> c.getName().equals(name)).findAny().get();
    }

    public void addCounty(County county) {
        counties.put(county, this);
    }

    public String getCountyCapitals(){
        List<City> listOfCapitals = Arrays.stream(getCounties()).map(County::getCapital).collect(Collectors.toList());
        StringBuilder capitals = new StringBuilder();
        for (City capital:
             listOfCapitals) {
            capitals.append(capital).append("\n");
        }
        return capitals.toString();
    }

    public void stateEcho() {
        System.out.printf("Capital of %s is %s. Counties number is %d. The area is %d.\n All county capitals: \n%s",
                getName(), capital, counties.size(), getArea(), getCountyCapitals());
    }

    public static void main(String[] args) {
        State uganda = new State("Uganda", 12_700_000, 8900_000,
                new City("Minsk"));
        County[] counties = new County[]{
                new County("Minskaya", 2500_000, 3000_000, uganda, new City("Minsk")),
                new County("Gomelskaya", 2100_000, 2000_000, uganda, new City("Gomel")),
                new County("Brestskaya", 2000_000, 1000_000, uganda, new City("Brest")),
                new County("Grodnenskaya", 1900_000, 1000_000, uganda, new City("Grodno")),
                new County("Vitebskaya", 2000_000, 900_000, uganda, new City("Vitebsk")),
                new County("Mogilyevskaya", 2200_000, 1000_000, uganda, new City("Mogilyev")),
        };

        uganda.updateArea();

        uganda.getCountyByName("Minskaya")
                .addRegion(new Region("Smolevichi"))
                .addRegion(new Region("Horoshki"));

        uganda.getCountyByName("Minskaya").getRegionByName("Smolevichi").addCity(new City("Smolevichi"));
        new City("Rogozhki").addToRegion(County.getRegionByNameStatic("Smolevichi"));

        uganda.stateEcho();
    }
}