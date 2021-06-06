package com.epam.practice5.PresentComposition;

import com.epam.practice5.PresentComposition.present.Present;
import com.epam.practice5.PresentComposition.presentBuilder.PresentBuilder;

public class Director{
    private PresentBuilder builder;
    void setBuilder(PresentBuilder builder){this.builder = builder;}

    Present buildPresent(){
        builder.createPresent();
        builder.buildPresentProduct();
        builder.buildPresentWrapper();
        Present present = builder.getPresent();

        return present;
    }
}