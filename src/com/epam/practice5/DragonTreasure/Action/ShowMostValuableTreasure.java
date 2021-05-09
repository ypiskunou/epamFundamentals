package com.epam.practice5.DragonTreasure.Action;

import com.epam.practice5.DragonTreasure.Dragon.IDragon;
import com.epam.practice5.DragonTreasure.Treasure.ITreasure;
import com.epam.practice5.DragonTreasure.Treasure.Precious;
import com.epam.practice5.DragonTreasure.Treasure.Treasure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowMostValuableTreasure implements Action {
    @Override
    public ITreasure action(ITreasure treasure, IDragon dragon) {
        System.out.println("Most valuable precious thing: ");
        List<Precious> preciousThings = treasure.getTreasure();
        Collections.sort(preciousThings);
        Precious mostValuable = treasure.getTreasure().get(preciousThings.size()-1);
        List<Precious> result = new ArrayList<>();
        result.add(mostValuable);
        return new Treasure(result);
    }
}
