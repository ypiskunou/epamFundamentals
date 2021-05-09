package com.epam.practice5.DragonTreasure.Action;

import com.epam.practice5.DragonTreasure.Dragon.IDragon;
import com.epam.practice5.DragonTreasure.Treasure.ITreasure;

public class ShowTreasure implements Action {

    @Override
    public ITreasure action(ITreasure treasure, IDragon dragon) {
        System.out.println("My treasure cosists of... khe-khe... \n");

        return treasure;
    }
}
