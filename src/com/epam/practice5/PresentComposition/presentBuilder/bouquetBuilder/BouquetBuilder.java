package com.epam.practice5.PresentComposition.presentBuilder.bouquetBuilder;

import com.epam.practice5.PresentComposition.present.Material;
import com.epam.practice5.PresentComposition.present.Present;
import com.epam.practice5.PresentComposition.present.bouquet.*;
import com.epam.practice5.PresentComposition.presentBuilder.PresentBuilder;

import java.util.HashMap;
import java.util.Map;

public class BouquetBuilder extends PresentBuilder {
    private Map<Flower, Integer> flowersToQty = new HashMap<Flower, Integer>();

    private FlowerSet flowerSet;
    private BouquetWrapper wrapper = new BouquetWrapper(Material.PAPER, 2);
    private int price;

    public void createPresent(){
        present = new Bouquet();
    }

    public void buildPresentProduct(){
        createFlowersToQty();
        flowerSet = new FlowerSet(flowersToQty);
        present.setProduct(flowerSet);
    }

    public void buildPresentWrapper(){
        present.setWrapper(wrapper);
    }

    public Present getPresent(){
        return present;
    }

    private void putFlowerInBouquet(String flower, int qty){
        FlowerProvider provider = FlowerSet.getProvider();
        Map.Entry<Flower, Integer> toAdd = provider.popFlowersOfStorage(provider.stringToFlower(flower), qty);
        flowersToQty.put(toAdd.getKey(), toAdd.getValue());
    }

    private void createFlowersToQty(){
        putFlowerInBouquet("Red rose 15cm", 3);
        putFlowerInBouquet("Yellow tulip 23cm", 5);
        putFlowerInBouquet("White lilly 20cm", 5);
        flowerSet = new FlowerSet(flowersToQty);
    }
}