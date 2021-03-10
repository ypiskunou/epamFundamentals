package com.epam.practice4.Composition.TourAgency;

import sun.rmi.transport.Transport;

import java.util.Map;

public enum Country implements PayableOption{

    LATVIA,
    LITHUANIA,
    ESTONIA,
    DENMARK,
    SWEDEN;

    private TransportType transportType;


    private static double[] prices = null;

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType){
        this.transportType = transportType;
        transportType.setCountry(this);
        prices = transportType.getPrices();
    }

    @Override
    public double[] getPrices() {
        if(prices == null)
            throw new ExceptionInInitializerError("You need to define transport first!");
        return transportType.getPrices();
    }
}
