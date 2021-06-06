package com.epam.practice5.PresentComposition.present.bouquet;

import com.epam.practice5.PresentComposition.present.PresentProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FlowerSet extends PresentProduct {
    private Map<Flower, Integer> flowersToQty;
    private static FlowerProvider provider = new FlowerProvider();
    private static Map<Flower, Integer> flowersToPrice = new HashMap<Flower, Integer>(){{
        put(provider.stringToFlower("Red rose 15cm"), 1_25);
        put(provider.stringToFlower("White rose 15cm"), 1_10);
        put(provider.stringToFlower("Yellow tulip 15cm"), 1_00);
        put(provider.stringToFlower("White lilly 15cm"), 75);
    }};

    public static FlowerProvider getProvider() {
        return provider;
    }

    public void setFlowersToQty(Map<Flower, Integer> flowersToQty) {
        this.flowersToQty = flowersToQty;
    }

    public FlowerSet(Map<Flower, Integer> flowersToQty) {
        this.flowersToQty = flowersToQty;
    }

    @Override
    public String toString() {
        return "FlowerSet{" +
                "flowersToQty=" + flowersToQty +
                '}';
    }
}