package com.epam.practice4.Composition.Bank;

import java.util.ArrayList;

public abstract class BankEntityAbstract {

    public int idGenerator(ArrayList<Integer> ids){
        int id = (int)(Math.random()*9000)+1000;
        int i = 0;

        while(ids.contains(id) && i < 9000){ // if all keys are full
            id = (int)(Math.random()*9000)+1000;
            i++;
        }
        if(i == 10000) throw new ExceptionInInitializerError("Overload of ids!");
        return id;
    }
}
