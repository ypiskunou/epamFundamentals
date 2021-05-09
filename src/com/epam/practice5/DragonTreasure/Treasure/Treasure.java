package com.epam.practice5.DragonTreasure.Treasure;

import java.util.List;

public class Treasure implements ITreasure {
    private List<Precious> treasure;

    public Treasure(List<Precious> treasure){
        this.treasure = treasure;
    }

    public List<Precious> getTreasure() {
        return treasure;
    }
}
