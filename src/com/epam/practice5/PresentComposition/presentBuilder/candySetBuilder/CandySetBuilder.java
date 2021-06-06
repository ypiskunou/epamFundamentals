package com.epam.practice5.PresentComposition.presentBuilder.candySetBuilder;

import com.epam.practice5.PresentComposition.present.Material;
import com.epam.practice5.PresentComposition.present.candySet.CandySetPresent;
import com.epam.practice5.PresentComposition.present.candySet.CandySet;
import com.epam.practice5.PresentComposition.present.candySet.CandySetWrapper;
import com.epam.practice5.PresentComposition.presentBuilder.PresentBuilder;

import java.util.HashMap;
import java.util.Map;

public class CandySetBuilder extends PresentBuilder {
    private Map<String, Integer> candyToQty = new HashMap<String, Integer>(){{
        put("zefirka", 5);
        put("korovka", 4);
    }};

    private CandySet candySet = new CandySet(candyToQty);
    private CandySetWrapper candySetWrapper = new CandySetWrapper(Material.CARTON, 4);
    private int price;

    @Override
    public void createPresent() {
        present = new CandySetPresent();
    }

    @Override
    public void buildPresentProduct() {
        present.setProduct(candySet);
    }

    @Override
    public void buildPresentWrapper() {
        present.setWrapper(candySetWrapper);
    }

//    public CandySetBuilderRR buildCandies(Map<String, Integer> candyToQty){
//        this.candyToQty = candyToQty;
//        return this;
//    }
//
//    public CandySetBuilderRR buildWrapper(CandySetWrapper candySetWrapper){
//        this.candySetWrapper = candySetWrapper;
//        return this;
//    }
//
//    public CandySet build(){
//        CandySet candySet = new CandySet();
//        candySet.setCandyToQty(candyToQty);
//
//        return candySet;
//    }
}