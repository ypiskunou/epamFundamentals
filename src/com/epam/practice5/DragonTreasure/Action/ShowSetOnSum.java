package com.epam.practice5.DragonTreasure.Action;

import com.epam.practice5.DragonTreasure.Dragon.IDragon;
import com.epam.practice5.DragonTreasure.Treasure.ITreasure;
import com.epam.practice5.DragonTreasure.Treasure.Precious;
import com.epam.practice5.DragonTreasure.Treasure.Treasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShowSetOnSum implements Action {

    @Override
    public ITreasure action(ITreasure treasure, IDragon dragon) {
        List<Precious> preciousList = treasure.getTreasure();

        Map<Integer, List<Precious>> groupedByPrice = preciousList.stream()
                .collect(Collectors.groupingBy(Precious::getPrice));

        int sum = -1;
        while (sum < 0) {
            System.out.println("Enter amount of money to get treasure for: ");
            try {
                sum = Integer.parseInt(readLn());
            } catch (NumberFormatException exc) {
                System.out.println("Enter some positive integer");
            }
        }
        String result = String.format("Treasures on sum of %d: ", sum);
        System.out.println(result);

        return giveJewelsWithLeastResidual(groupedByPrice, sum);
    }

    private Treasure giveJewelsWithLeastResidual(Map<Integer, List<Precious>> groupedByPrice, int amount) {
        ArrayList<Integer> prices = new ArrayList<>(groupedByPrice.keySet());
        prices.sort(Comparator.reverseOrder());

        int min = prices.get(0);
        int residual = amount;
        int minOfIteration = residual;
        int[] itemQty = new int[prices.size()];
        int[] itemQtyOpt = new int[prices.size()];
        int newStart = 0;
        boolean firstChange;

        for (int j = newStart; j < prices.size(); j++) {
            residual = amount;
            if (min < minOfIteration) {
                itemQtyOpt = Arrays.copyOf(itemQty, itemQty.length);
            }
            itemQty = new int[prices.size()];
            minOfIteration = min;
            if (minOfIteration == 0)
                break;

            firstChange = true;
            for (int i = j; i < prices.size(); i++) {
                if (i > 0 && i == j)
                    continue;
                int price = prices.get(i);
                int q = residual / price;
                if (q == 0)
                    continue;
                else if (firstChange) {
                    newStart = i + 1;
                    firstChange = false;
                }
                int n = groupedByPrice.get(price).size();
                int properQ = Math.min(n, q);

                residual -= properQ * price;
                itemQty[i] += properQ;
                if (residual == 0)
                    break;
            }

            if (residual < min)
                min = residual;
        }

        ArrayList<Precious> listOfTreasures = new ArrayList<>();
        for (int i = 0; i < itemQtyOpt.length; i++)
            for (int j = 0; j < itemQtyOpt[i]; j++)
                listOfTreasures.add(groupedByPrice.get(prices.get(i)).get(j));

        return new Treasure(listOfTreasures);
    }

    private String readLn() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
