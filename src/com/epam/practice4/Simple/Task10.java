package com.epam.practice4.Simple;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Piskunou Yury
 * @my.task 10. Создать класс Airline, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод  toString().
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * <p>
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 * @since 07.02.21
 */

enum PlaneType {
    AIRBUS,
    BOEING,
    EMBRAER
}

class Airline {

    private String destination;
    private int number;
    private PlaneType planeType;
    private LocalTime departure;
    private DayOfWeek dayOfWeek;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDestination() {

        return destination;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public Airline(String destination, int number, PlaneType planeType, LocalTime departure, DayOfWeek dayOfWeek) {
        this.destination = destination;
        this.number = number;
        this.planeType = planeType;
        this.departure = departure;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", number=" + number +
                ", planeType=" + planeType +
                ", departure=" + departure +
                ", daysOfWeek=" + dayOfWeek +
                '}';
    }
}

class Airport {

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    private ArrayList<Airline> airlines;

    public Airport(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public void airlinesByDestination(String destination) {
        ArrayList<Airline> airlinesList = airlines.stream()
                .filter(c -> c.getDestination().equals(destination)).collect(Collectors.toCollection(ArrayList::new));
        for (Airline airline :
                airlinesList) {
            System.out.println(airline);
        }
    }

    public void airlinesByWeekDay(DayOfWeek dayOfWeek) {
        ArrayList<Airline> airlinesList = airlines.stream()
                .filter(c -> c.getDayOfWeek().equals(dayOfWeek)).collect(Collectors.toCollection(ArrayList::new));
        for (Airline airline :
                airlinesList) {
            System.out.println(airline);
        }
    }

    public void airlinesByWeekDayAndAfterTime(DayOfWeek dayOfWeek, LocalTime departureAfter) {
        ArrayList<Airline> airlinesList = airlines.stream()
                .filter(c -> c.getDayOfWeek().equals(dayOfWeek) && c.getDeparture().isAfter(departureAfter))
                .collect(Collectors.toCollection(ArrayList::new));
        for (Airline airline :
                airlinesList) {
            System.out.println(airline);
        }
    }


    public static void main(String[] args) {

        ArrayList<Airline> airlines = new ArrayList<>(Arrays.asList(
                new Airline("Warsaw", 1455, PlaneType.AIRBUS,
                        LocalTime.of(7, 40), DayOfWeek.THURSDAY),
                new Airline("Bonn", 1298, PlaneType.AIRBUS,
                        LocalTime.of(9, 20), DayOfWeek.THURSDAY),
                new Airline("Orlando", 5565, PlaneType.BOEING,
                        LocalTime.of(11, 25), DayOfWeek.FRIDAY),
                new Airline("NY", 5545, PlaneType.BOEING,
                        LocalTime.of(15, 50), DayOfWeek.SATURDAY),
                new Airline("Bangkok", 3127, PlaneType.EMBRAER,
                        LocalTime.of(7, 40), DayOfWeek.MONDAY),
                new Airline("Warsaw", 1121, PlaneType.AIRBUS,
                        LocalTime.of(11, 45), DayOfWeek.TUESDAY),
                new Airline("London", 7548, PlaneType.EMBRAER,
                        LocalTime.of(19, 10), DayOfWeek.FRIDAY)
        ));

        Airport airport = new Airport(airlines);

        String destinationToFind = "Warsaw";
        System.out.printf("\nAll airlines to %s \n", destinationToFind);
        airport.airlinesByDestination(destinationToFind);

        DayOfWeek dayOfWeekToFind = DayOfWeek.FRIDAY;
        System.out.printf("\nAll airlines on %s \n", dayOfWeekToFind.toString());
        airport.airlinesByWeekDay(dayOfWeekToFind);

        DayOfWeek dayOfWeekToFindAfterTime = DayOfWeek.FRIDAY;
        LocalTime departureAfter = LocalTime.of(14, 0);
        System.out.printf("\nAll airlines on %s after the time %s\n", dayOfWeekToFind.toString(), departureAfter);
        airport.airlinesByWeekDayAndAfterTime(dayOfWeekToFindAfterTime, departureAfter);
    }

}