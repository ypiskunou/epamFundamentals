package com.epam.practice4.Simple;

/**
 * @author Piskunou Yury
 * @my.task 6. Составьте описание класса для представления времени.
 * Предусмотрте возможности установки времени и изменения его отдельных полей (час, минута, секунда)
 * с проверкой допустимости вводимых значений. В случае недопустимых значений полей поле устанавливается в значение 0.
 * Создать методы изменения времени на заданное количество часов, минут и секунд.
 * @since 07.02.21
 */

class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public void setHours(int hours) {
        this.hours = hours;
        if (hours < 0 || hours > 23)
            this.hours = 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        if (minutes < 0 || minutes > 59)
            this.minutes = 0;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
        if (seconds < 0 || seconds > 59)
            this.seconds = 0;
    }

    public Time(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    private int timeToSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    private void setSecondsToTime(int timeInSeconds){
        hours = timeInSeconds/3600;
        timeInSeconds %= 3600;
        minutes = timeInSeconds/60;
        timeInSeconds %= 60;
        seconds = timeInSeconds;
    }

    public void decrementTime(int _hours, int _minutes, int _seconds) {
        int timeToSeconds = _hours * 3600 + _minutes * 60 + _seconds;
        int resultingSeconds = hours * 3600 + minutes * 60 + seconds - timeToSeconds;
        if(resultingSeconds < 0)
            resultingSeconds += 24*3600;
        setSecondsToTime(resultingSeconds);
    }

    public void incrementTime(int _hours, int _minutes, int _seconds) {
        seconds += _seconds;
        minutes += seconds / 60;
        seconds %= 60;

        minutes += _minutes;
        hours += minutes / 60;
        minutes %= 60;
        hours += _hours;
        hours %= 24;
    }

    @Override
    public String toString(){
        return hours + "hrs " + minutes + "m " + seconds + "s ";
    }

    public static void main(String[] args) {

        Time time = new Time(25, 45, 65);
        System.out.println("Current time is " + time);
        time.incrementTime(25, 105, 3000);
        System.out.println("Incremented time is " + time);
        time.decrementTime(7, 3,2);
        System.out.println("Decremented time is " + time);
    }
}
