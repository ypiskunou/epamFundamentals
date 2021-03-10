package com.epam.practice4.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;

/**
 * @author Piskunou Yury
 * @my.task 4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 * @since 03.02.21
 */

public class Train {
    private static Train[] trains = new Train[]{
            new Train("Warsaw", 123, LocalTime.of(7, 40)),
            new Train("Warsaw", 271, LocalTime.of(9, 50)),
            new Train("Berlin", 745, LocalTime.of(12, 45)),
            new Train("Kopengagen", 312, LocalTime.of(14, 20)),
            new Train("Malme", 850, LocalTime.of(16, 30)),
    };

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    private String destination;
    private int trainNumber;
    private LocalTime departureTime;

    public Train(String destination, int trainNumber, LocalTime departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return (destination + " - " + trainNumber + " - " + departureTime);
    }

    private static int numberDialog() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of train: ");
        return Integer.parseInt(bufferedReader.readLine());
    }

    private static void printAllTrains() {
        for (Train train : trains) System.out.println(train);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> trainIds = new TreeMap<>();

        if (trains.length != 5) throw new IllegalArgumentException();

        for (int i = 0; i < trains.length; i++) {
            trainIds.put(trains[i].trainNumber, i);
        }

        char quit = 0;
        while (quit != 'q') {
            int input = -1;
            while (!trainIds.containsKey(input))//(input < 0)
                try {
                    input = numberDialog();
                } catch (IOException exc) {
                    System.out.println("You need to enter a proper train id. ");
                }
            System.out.println(trains[trainIds.get(input)]);

            System.out.println();
            printAllTrains();

            Arrays.sort(trains, new trainNumberComparator());
            System.out.println("\n Trains sorted by number of train: ");
            printAllTrains();

            Arrays.sort(trains, (new destinationComparator()).thenComparing(new departureTimeComparator()));
            System.out.println("\n Trains sorted by destination then by departure time: ");
            printAllTrains();

            System.out.println("\n Enter q - to quit: ");
            try {
                quit = (char) new BufferedReader(new InputStreamReader(System.in)).read();
            } catch (IOException exc){
                System.out.println(exc.getMessage());
            }
        }
    }
}

class trainNumberComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        if (o1.getTrainNumber() < o2.getTrainNumber())
            return -1;
        else if (o1.getTrainNumber() > o2.getTrainNumber())
            return 1;
        return 0;
    }
}

class destinationComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        return o1.getDestination().compareTo(o2.getDestination());
    }
}

class departureTimeComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        return o1.getDepartureTime().compareTo(o2.getDepartureTime());
    }
}