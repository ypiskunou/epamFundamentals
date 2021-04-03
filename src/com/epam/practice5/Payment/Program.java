package com.epam.practice5.Payment;

public class Program {
    public static void main(String[] args){
        try {
            Payment pay = new Payment("Покупка");
            pay.setPayment();
            pay.printCheque();
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат");
        } catch (NullPointerException e) {
            System.out.println("Массив не создан");
        }

    }
}
