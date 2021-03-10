package com.epam.practice4.Composition.TourAgency;

public enum TourType implements PayableOption{
    REST,
    EXCURSION,
    MEDICAL,
    SHOPPING,
    CRUISE,
    HUNTING,
    EXTREME;

    private static double[] prices = new double[] { // per day
                    20,
                    5,
                    30,
                    5,
                    75,
                    50,
                    150
            };

    public double[] getPrices() {
        return prices;
    }
}
