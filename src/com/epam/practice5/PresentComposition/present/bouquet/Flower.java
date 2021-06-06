package com.epam.practice5.PresentComposition.present.bouquet;

import java.util.Objects;

public class Flower{
    private String name;
    private Color color;
    private int height;
    private int price;

    public Flower(){}

    public Flower(String name, Color color, int height) {
        this.name = name;
        this.color = color;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return height == flower.height &&
                price == flower.price &&
                name.equals(flower.name) &&
                color == flower.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, color, height, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color='" + color + '\'' +
                ", name=" + name +
                ", height=" + height +
                ", price=" + price +
                '}';
    }
}