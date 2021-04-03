package com.epam.practice5.Calendar;

public class Schedule {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.addDayOffs(new Calendar.DayOff[]{
                calendar. new DayOff(3, 4),
                calendar. new DayOff(10, 4, "cafe at 17.30"),
                calendar. new StateHolliday("Peisakh", 1, 4, "Pirrrr"),
                calendar. new StateHolliday("Independence", 4, 7),
                calendar. new StateHolliday("New Year", 1, 1),
                calendar. new StateHolliday("Thanksgiving", 27, 10)
        });

        System.out.println(calendar.getHollidayByDate(27, 10).name);
        System.out.println(calendar.getHollidayByDate(1, 4));
        System.out.println(calendar.getHollidayByDate(10, 4));
    }
}