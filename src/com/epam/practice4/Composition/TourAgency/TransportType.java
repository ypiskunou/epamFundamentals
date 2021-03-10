package com.epam.practice4.Composition.TourAgency;

public enum TransportType implements PayableOption{
    BUS,
    TRAIN,
    SHIP,
    PLANE;

    private Country country;
    private static double[][] prices = new double[][] {
            new double[]{50, 40, 70, 100, 120},
            new double[]{45, 35, 60, 80, 110},
            new double[]{-1, -1, -1, 95, 105},
            new double[]{300, 250, 350, 700, 1200}
    };

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public double[] getPrices() {
        return prices[country.getTransportType().ordinal()];
    }
}
