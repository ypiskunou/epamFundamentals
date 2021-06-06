package com.epam.practice5.PresentComposition.present.candySet;

import com.epam.practice5.PresentComposition.present.Present;

public class CandySetPresent extends Present {
    private String name;
    //    private CandySet candySet;
//    private CandySetWrapper candySetWrapper;
    private int price = 5;
    //region setters
    public void setName(String name) {
        this.name = name;
    }

//    public void setCandySet(CandySet candySet) {
//        this.candySet = candySet;
//    }
//
//    public void setCandySetWrapper(CandySetWrapper candySetWrapper) {
//        this.candySetWrapper = candySetWrapper;
//    }

    public void setPrice(int price) {
        this.price = price;
    }
    //endregion

    @Override
    public String toString() {
        return "CandySetPresent{" +
                "candySet=" + getProduct() +
                ", candySetWrapper=" + getWrapper() +
                '}';
    }
}