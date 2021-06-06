package com.epam.practice5.PresentComposition.present.candySet;

import com.epam.practice5.PresentComposition.present.PresentProduct;

import java.util.Map;

public class CandySet extends PresentProduct {
    private String name = "Assorti";
    private Map<String, Integer> candyToQty;
    private int price;

    public CandySet(Map<String, Integer> candyToQty) {
        this.candyToQty = candyToQty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCandyToQty(Map<String, Integer> candyToQty) {
        this.candyToQty = candyToQty;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CandySet{" +
                "name='" + name + '\'' +
                ", candyToQty=" + candyToQty +
                ", price=" + price +
                '}';
    }
}