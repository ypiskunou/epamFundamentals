package com.epam.practice5.PresentComposition.presentBuilder;

import com.epam.practice5.PresentComposition.present.Present;

public abstract class PresentBuilder{
    protected Present present;
    //void createBouquet(){present = new Bouquet();}
    //void createCandySet(){present = new CandySet();}

    public abstract void createPresent();
    public abstract void buildPresentProduct();
    public abstract void buildPresentWrapper();

    public Present getPresent(){return present;}
}