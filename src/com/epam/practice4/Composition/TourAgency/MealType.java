package com.epam.practice4.Composition.TourAgency;

public enum MealType implements PayableOption {
    BREAKFAST,
    CANTEEN,
    LUNCH,
    SUPPER;

    private static double[] prices = new double[]{
            10,
            15,
            5,
            7
    };

    public double[] getPrices() {
        return prices;
    }
}