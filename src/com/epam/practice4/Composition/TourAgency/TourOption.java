package com.epam.practice4.Composition.TourAgency;

import java.util.Arrays;

public class TourOption {
    private TourType[] tourTypes;
    private MealType[] mealTypes;
    private int days;

    private double price = 0;

    public TourOption(TourType[] tourTypes, MealType[] mealTypes, int days) {
        this.tourTypes = tourTypes;
        this.mealTypes = mealTypes;
        this.days = days;
        sumPrice(tourTypes);
        sumPrice(mealTypes);
    }

    @Override
    public String toString() {
        return "TourOption{" +
                "tourTypes=" + Arrays.toString(tourTypes) +
                ", mealTypes=" + Arrays.toString(mealTypes) +
                ", days=" + days +
                '}';
    }

    private void sumPrice(PayableOption[] optionTypes) {
        for (PayableOption payableOption :
                optionTypes) {
            price += payableOption.getPrices()[((Enum)payableOption).ordinal()];
        }
    }

    public double getPrice() {
        return price * days;
    }

    public TourType[] getTourTypes() {
        return tourTypes;
    }

    public MealType[] getMealTypes() {
        return mealTypes;
    }

    public int getDays() {
        return days;
    }
}
