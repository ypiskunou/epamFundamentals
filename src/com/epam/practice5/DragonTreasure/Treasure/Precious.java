package com.epam.practice5.DragonTreasure.Treasure;

public class Precious implements Comparable<Precious>{
    private String name;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    private int price;


    public Precious(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Precious:{" +
                "name: " + name +
                ", price: " + price +
                '}';
    }

    @Override
    public int compareTo(Precious o) {
        return Integer.compare(this.price, o.price);
    }
}
