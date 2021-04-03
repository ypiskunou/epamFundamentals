package com.epam.practice5.Calendar;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Piskunou Yury
 * @my.task 3. Создать класс Календарь с внутренним классом, с помощью объектов которого
 * можно хранить информацию о выходных и праздничных днях.
 * @since 06.02.21
 */
public class Calendar {
    private TreeMap<DayOff, String> hollidays = new TreeMap<>();

    public DayOff getHollidayByName(String name) {
        return (DayOff) hollidays
                .entrySet()
                .stream()
                .filter(entry -> name.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    public DayOff getHollidayByDate(int day, int month) {
        testDate(day, month);
        DayOff dayOff = new DayOff(day, month);
        String holliday = hollidays.get(dayOff);
        if (holliday.equals("DayOff"))
            return hollidays.tailMap(dayOff, true).firstKey();//return dayOff;
        else return getHollidayByName(holliday);
    }

    private void testDate(int day, int month) {
        try {
            LocalDate.of(LocalDate.now().getYear(), month, day);
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public void addDayOffs(DayOff[] dayOffs) {
        for (DayOff dayOff :
                dayOffs) {
            addDayOff(dayOff);
        }
    }

    public Calendar addDayOff(DayOff dayOff) {
        hollidays.put(dayOff, dayOff.name);
        return this;
    }

    public DayOff findNextHolliday(DayOff day) {
        return (DayOff) hollidays.ceilingEntry(day);
    }

    public DayOff dateToDayOff(LocalDate localDate) {
        return new DayOff(localDate.getDayOfMonth(), localDate.getMonthValue());
    }

    public LocalDate dayOffToDate(DayOff dayOff) {
        return dayOff.localDate;
    }

    @Override
    public String toString() {
        StringJoiner dayOffsString = new StringJoiner(", ");
        for (DayOff dayOff :
                hollidays.keySet()) {
            dayOffsString.add(dayOff.toString());
        }

        return dayOffsString.toString();
    }


    class DayOff implements Comparable {
        protected String name;
        protected LocalDate localDate;
        String event = "";

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public DayOff() {
        }

        public DayOff(int day, int month, String... event) {
            name = "DayOff";
            localDate = LocalDate.of(LocalDate.now().getYear(), month, day);
            if (event.length > 0)
                this.event = event[0];
        }

        @Override
        public String toString() {
            return "DayOff{" +
                    "name='" + name + '\'' +
                    ", localDate=" + localDate +
                    ", event='" + event + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            return this.localDate.compareTo(((DayOff) o).localDate);
        }
    }

    class StateHolliday extends DayOff {
        public StateHolliday(String name, LocalDate localDate) {
            this.name = name;
            this.localDate = localDate;
        }

        public StateHolliday(String name, int day, int month, String... event) {
            super(day, month, event);
            this.name = name;
        }
    }
}
