package com.epam.practice5.PresentComposition.present.bouquet;

import com.epam.practice5.PresentComposition.present.Material;
import com.epam.practice5.PresentComposition.present.PresentWrapper;

public class BouquetWrapper extends PresentWrapper {
    private Material material;
    private int price;

    public BouquetWrapper(Material material, int price) {
        this.material = material;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BouquetWrapper{" +
                "material=" + material +
                ", price=" + price +
                '}';
    }
}