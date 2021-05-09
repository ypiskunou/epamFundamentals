package com.epam.practice5.DragonTreasure;

import com.epam.practice5.DragonTreasure.Dragon.Dragon;
import com.epam.practice5.DragonTreasure.Dragon.IDragon;
import com.epam.practice5.DragonTreasure.Menu.IMenu;
import com.epam.practice5.DragonTreasure.Menu.Menu;
import com.epam.practice5.DragonTreasure.Treasure.ITreasure;
import com.epam.practice5.DragonTreasure.Treasure.TreasureGenerator;
import com.epam.practice5.DragonTreasure.Treasure.TreasureProvider;

public class Program {

    public static void main(String[] args) {
        TreasureProvider treasureProvider = new TreasureGenerator();
        ITreasure treasure = treasureProvider.loadTreasure();
        IDragon dragon = new Dragon();
        IMenu menu = new Menu(treasure, dragon);

        menu.execute();
    }
}
