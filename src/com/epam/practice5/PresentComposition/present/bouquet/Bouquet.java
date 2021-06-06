package com.epam.practice5.PresentComposition.present.bouquet;

import com.epam.practice5.PresentComposition.present.Present;

public class Bouquet extends Present {
    private int price;
    //region setters
    public void setFlowerSet(FlowerSet flowerSet) {
        super.product = super.product;
    }

    public void setWrapper(BouquetWrapper wrapper) {
        super.wrapper = wrapper;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //endregion

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowerSet=" + product +
                ", wrapper=" + wrapper +
                '}';
    }
}