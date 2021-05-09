package com.epam.practice5.DragonTreasure.Dragon;

import com.epam.practice5.DragonTreasure.Treasure.ITreasure;
import com.epam.practice5.DragonTreasure.Treasure.Precious;

/**
 * @author Piskunou Yury
 * @my.task 4. Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах
 * в пещере дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости
 * сокровища и выбора сокровищ на заданную сумму.
 */
public class Dragon implements IDragon {
    @Override
    public void showTreasure(ITreasure treasure) {
        for (Precious thing:
             treasure.getTreasure()) {
            System.out.println(thing);
        }
    }
}