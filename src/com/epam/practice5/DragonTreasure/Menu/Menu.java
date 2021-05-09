package com.epam.practice5.DragonTreasure.Menu;

import com.epam.practice5.DragonTreasure.Action.Action;
import com.epam.practice5.DragonTreasure.Action.ShowMostValuableTreasure;
import com.epam.practice5.DragonTreasure.Action.ShowSetOnSum;
import com.epam.practice5.DragonTreasure.Action.ShowTreasure;
import com.epam.practice5.DragonTreasure.Dragon.IDragon;
import com.epam.practice5.DragonTreasure.Treasure.ITreasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu implements IMenu {
    private ITreasure treasure;
    private IDragon dragon;

    public Menu(ITreasure treasure, IDragon dragon){
        this.treasure = treasure;
        this.dragon = dragon;
    }

    public void execute(){
        int input;
        Action[] menu = new Action[]{
                new ShowTreasure(),
                new ShowMostValuableTreasure(),
                new ShowSetOnSum()
        };
        while (true) {
            System.out.println("\nEnter number of operation you'd like to do: \n" +
                    "0) - quit\n" +
                    "1) - show treasure\n" +
                    "2) - choose most valuable\n" +
                    "3) - choose set of precious things on defined cost.");
            input = Integer.parseInt(readLn());
            if (input == 0) break;
            if(input < 0 || input > menu.length)
                continue;

            dragon.showTreasure(menu[input - 1].action(treasure, dragon));
        }
    }

    private String readLn(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}