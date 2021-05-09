package com.epam.practice5.DragonTreasure.Treasure;

import java.util.ArrayList;

public class TreasureGenerator implements TreasureProvider{
    private static String[] treasureNames = new String[]{
            "Ruby",
            "Pearl",
            "Diamond",
            "Gold"
    };

    private static int[] treasurePrices = new int[]{
            500, 300, 1000, 200
    };

    private final static int PRECIOUS_QTY = 100;

    public Treasure loadTreasure(){
        ArrayList<Precious> treasure = new ArrayList<>();
        for(int i = 0; i < PRECIOUS_QTY; i++){
            int n = (int) (Math.random()*treasureNames.length);
            treasure.add(new Precious(treasureNames[n], treasurePrices[n]));
        }
        return new Treasure(treasure);
    }
}
