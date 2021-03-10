package com.epam.practice4.Composition.TourAgency;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @author Piskunou Yury
 * @my.task 4. Счета.
 * 5. Туристические путевки.
 * Сформировать набор предложений клиенту по выбору туристической путевки различного типа
 * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
 * Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 * @since 09.01.21
 */

public class TourAgency {

    private String name;
    private Map<Integer, Tour> orders = new HashMap<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private TourOption popular
            = new TourOption(new TourType[]{TourType.REST,
            TourType.EXCURSION}, new MealType[]{MealType.BREAKFAST}, 10);
    private TourOption commersial
            = new TourOption(new TourType[]{TourType.REST,
            TourType.SHOPPING}, new MealType[]{MealType.BREAKFAST}, 5);
    private TourOption youth
            = new TourOption(new TourType[]{TourType.EXTREME,
            TourType.EXCURSION}, new MealType[]{MealType.BREAKFAST}, 14);
    private TourOption health
            = new TourOption(new TourType[]{TourType.MEDICAL,
            TourType.REST}, new MealType[]{MealType.BREAKFAST, MealType.CANTEEN}, 21);
    private TourOption hunting
            = new TourOption(new TourType[]{TourType.HUNTING,
            TourType.REST}, new MealType[]{MealType.BREAKFAST, MealType.LUNCH}, 7);
    private TourOption huntingOnWeekend
            = new TourOption(new TourType[]{TourType.REST,
            TourType.HUNTING}, new MealType[]{MealType.BREAKFAST, MealType.LUNCH}, 2);
    private TourOption retire
            = new TourOption(new TourType[]{TourType.CRUISE,
            TourType.EXCURSION}, new MealType[]{MealType.CANTEEN}, 40);

    private Tour[] tours = new Tour[]{
            new Tour(Country.DENMARK, TransportType.PLANE, popular),
            new Tour(Country.SWEDEN, TransportType.SHIP, commersial),
            new Tour(Country.SWEDEN, TransportType.PLANE, youth),
            new Tour(Country.LATVIA, TransportType.BUS, health),
            new Tour(Country.DENMARK, TransportType.TRAIN, hunting),
            new Tour(Country.DENMARK, TransportType.BUS, huntingOnWeekend),
            new Tour(Country.SWEDEN, TransportType.SHIP, retire),
            new Tour(Country.ESTONIA, TransportType.PLANE, popular),
            new Tour(Country.LITHUANIA, TransportType.TRAIN, popular),
            new Tour(Country.LITHUANIA, TransportType.BUS, commersial),
    };

    public TourAgency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TourAgency addClient(Client client) {
        clients.add(client);
        return this;
    }

    public Map<Integer, Tour> getOrders() {
        return orders;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Tour[] getTours() {
        return tours;
    }

    public Tour[] sortToursOnCountry(Tour[] tours) {
        Arrays.sort(tours, Comparator.comparing(Tour::getCountry));
        return tours;
    }

    public Tour[] getToursOnCountry(Tour[] tours, String country) {
        Country toFind = Country.valueOf(country.toUpperCase());
        return Arrays.stream(tours).filter(t -> t.getCountry().equals(toFind)).toArray(Tour[]::new);
    }

    public Tour[] sortToursOnPrice(Tour[] tours) {
        Arrays.sort(tours);
        return tours;
    }

    public Tour[] getToursInPriceRange(Tour[] tours, double minPrice, double maxPrice) {
        return Arrays.stream(tours)
                .filter(t -> t.getPrice() >= minPrice && t.getPrice() <= maxPrice)
                .toArray(Tour[]::new);
    }

    public Tour[] sortToursOnTransport(Tour[] tours) {
        Arrays.sort(tours, Comparator.comparing(Tour::getTransportType));
        return tours;
    }

    public Tour[] getToursOnTransports(Tour[] tours, String[] transports) {
        TransportType[] toFinds = new TransportType[transports.length];
        int i = 0;
        for (String transport :
                transports) {
            toFinds[i++] = TransportType.valueOf(transport.toUpperCase());
        }
        ArrayList<Tour> toursList = new ArrayList<>();
        for (TransportType toFind :
                toFinds) {
            toursList.addAll(Arrays.stream(this.tours)
                    .filter(t -> t.getTransportType()
                            .equals(toFind))
                    .collect(Collectors.toCollection(ArrayList::new)));
        }
        return toursList.toArray(new Tour[toursList.size()]);
    }

    public Tour[] sortToursOnDurance(Tour[] tours) {
        Arrays.sort(tours, Comparator.comparing(t -> t.getTourOption().getDays()));
        return tours;
    }

    public Tour[] getToursOnDurance(Tour[] tours, int from, int to) {
        return Arrays.stream(tours)
                .filter(t -> t.getTourOption().getDays() >= from && t.getTourOption().getDays() <= to)
                .toArray(Tour[]::new);
    }

    public void printArrayOfTours(Tour[] tours){
        for (Tour tour:
             tours) {
            System.out.println(tour);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        TourAgency aloha = new TourAgency("Aloha");
        aloha.addClient(new Client("Ivan", "Rulkin"))
                .addClient(new Client("Dan", "Bukin"))
                .addClient(new Client("Arkhip", "Dudkin"))
                .addClient(new Client("Elena", "Bulkina"));

        aloha.getOrders().put(aloha.getClients().get(0).getId(), aloha.getTours()[0]);
        aloha.getOrders().put(aloha.getClients().get(1).getId(), aloha.getTours()[2]);
        aloha.getOrders().put(aloha.getClients().get(2).getId(), aloha.getTours()[1]);
        aloha.getOrders().put(aloha.getClients().get(3).getId(), aloha.getTours()[3]);
        aloha.getOrders().put(aloha.getClients().get(1).getId(), aloha.getTours()[1]);
        aloha.getOrders().put(aloha.getClients().get(2).getId(), aloha.getTours()[1]);

        String sweden = "Sweden";
        double maxPrice = 700;
        String[] transportTypes = new String[]{"bus", "ship", "train"};

        System.out.println("All tours: ");
        aloha.printArrayOfTours(aloha.getTours());

        System.out.println("All tours to Sweden: ");
        aloha.printArrayOfTours(aloha.getToursOnCountry(aloha.getTours(), sweden));

        System.out.println("Sort tours on countries: ");
        aloha.printArrayOfTours(aloha.sortToursOnCountry(aloha.getTours()));

        System.out.println("Tours under 1000$: ");
        aloha.printArrayOfTours(aloha.getToursInPriceRange(aloha.getTours(), 0,1000));

        System.out.println("Sort tours on prices: ");
        aloha.printArrayOfTours(aloha.sortToursOnPrice(aloha.getTours()));

        System.out.println("Tours by only bus or train: ");
        aloha.printArrayOfTours(aloha.getToursOnTransports(aloha.getTours(), new String[]{"bus", "train"}));

        System.out.println("Sort tours on transport: ");
        aloha.printArrayOfTours(aloha.sortToursOnTransport(aloha.getTours()));

        System.out.println("Tours in range from 10 to 20 days: ");
        aloha.printArrayOfTours(aloha.getToursOnDurance(aloha.getTours(), 10, 20));

        System.out.println("Sort tours on durance: ");
        aloha.printArrayOfTours(aloha.sortToursOnDurance(aloha.getTours()));
    }
}
