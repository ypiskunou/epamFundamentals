package com.epam.practice4.Composition.TourAgency;

public class Tour implements Comparable<Tour> {

    private double price;
    private Country country;
    private TransportType transportType;
    private TourOption tourOption;

    public Tour(Country country, TransportType transportType, TourOption tourOption) {
        this.country = country;
        country.setTransportType(transportType);
        this. transportType = transportType;
        this.tourOption = tourOption;

        price = tourOption.getPrice() + country.getPrices()[country.ordinal()];
    }

    public double getPrice() {
        return price;
    }

    public TourOption getTourOption() {
        return tourOption;
    }

    public Country getCountry() {
        return country;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    @Override
    public int compareTo(Tour o) {
        return Double.compare(getPrice(), o.getPrice());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "country=" + country +
                ", tourOption=" + tourOption +
                ", transport=" + transportType +
                ", price=" + price +
                '}';
    }
}
