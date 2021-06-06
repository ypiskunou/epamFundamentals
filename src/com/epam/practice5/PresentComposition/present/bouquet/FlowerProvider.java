package com.epam.practice5.PresentComposition.present.bouquet;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class FlowerProvider {
    private Map<Flower, Integer> flowerQty = new HashMap<>();

    public FlowerProvider() {
        flowerQty.put(stringToFlower("Red rose 15cm"), 5);
        flowerQty.put(stringToFlower("Yellow tulip 23cm"), 7);
        flowerQty.put(stringToFlower("White rose 30cm"), 11);
        flowerQty.put(stringToFlower("White lilly 20cm"), 5);
    }

    public Map<Flower, Integer> getFlowerQty() {
        return flowerQty;
    }

    public void setFlowerQty(Map<Flower, Integer> flowerQty) {
        this.flowerQty = flowerQty;
    }

    public Flower stringToFlower(String description){
        String[] attributes = description.split(" ");
        Color color = Color.valueOf(attributes[0].toUpperCase());
        Flower flower = new Flower(
                attributes[1].toLowerCase(),
                color,
                Integer.parseInt(attributes[2].replaceFirst("cm", ""))
        );

        return flower;
    }

    public Map.Entry<Flower, Integer> popFlowersOfStorage(Flower flower, int qty){
        if(!flowerQty.containsKey(flower)){
            throw new IllegalArgumentException("No such flower in access");
        }
        int flowersInAccess = flowerQty.get(flower);
        if(flowersInAccess < qty){
            throw new IllegalArgumentException("Not enough flowers. Only " + flowersInAccess + " is in stock.");
        }
        flowerQty.put(flower, flowersInAccess - qty);
        return new AbstractMap.SimpleEntry<Flower, Integer>(flower, qty);
    }
}
