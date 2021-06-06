package com.epam.practice5.PresentComposition.present.candySet;

import com.epam.practice5.PresentComposition.present.Material;
import com.epam.practice5.PresentComposition.present.PresentWrapper;

public class CandySetWrapper extends PresentWrapper {
    private Material material;
    private int price;

    public CandySetWrapper(Material material, int price) {
        this.material = material;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CandySetWrapper{" +
                "material=" + material +
                ", price=" + price +
                '}';
    }
}