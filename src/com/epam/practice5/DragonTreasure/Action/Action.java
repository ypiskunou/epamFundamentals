package com.epam.practice5.DragonTreasure.Action;

import com.epam.practice5.DragonTreasure.Dragon.IDragon;
import com.epam.practice5.DragonTreasure.Treasure.ITreasure;

public interface Action { // as ServiceProvider. Part of controller. Only returns model And kind of label - what is it
    ITreasure action(ITreasure treasure, IDragon dragon);
}
