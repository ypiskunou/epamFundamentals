package com.epam.practice5.Payment;

import java.util.Scanner;

/**
 * @author Piskunou Yury
 * @my.task 2. Создать класс Payment с внутренним классом, с помощью объектов которого
 * можно сформировать покупку из нескольких товаров.
 * @since 06.02.21
 */
public class Payment {
    private String name;
    private Product[] prodArray;
    private int cost;

    private class Product {
        private String productName;
        private int productCost;

        public Product() {
            productName = "";
            productCost = 0;
        }

        public Product(String productName, int productCost) {
            this.productName = productName;
            this.productCost = productCost;
        }

        public String getProductName() {
            return this.productName;
        }

        public int getProductCost() {
            return this.productCost;
        }
    }

    public Payment() {
        this.name = "";
        this.cost = 0;
    }

    public Payment(String name) {
        this.name = name;
    }

    public void setPayment() {
        this.cost = 0;
        System.out.print("Введите количество товаров, которое Вы хотите приобрести: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int quantity = scanner.nextInt();
            prodArray = new Product[quantity];
            for (int i = 0; i < quantity; i++) {
                System.out.println("Товар " + (i + 1) + ": ");
                System.out.print("Наименование: ");
                String str_name = scanner.next();
                System.out.print("Цена: ");
                int prod_cost = scanner.nextInt();
                prodArray[i] = new Product(str_name, prod_cost);
                this.cost = this.cost + prodArray[i].productCost;
            }

        } catch (NumberFormatException e) {
            System.out.println("Неверный формат");
        } catch (NegativeArraySizeException e) {
            System.out.println("Размерность массива не может быть < 0");
        } catch (NullPointerException e) {
            System.out.println();
            System.out.println("Массив не создан");
        }
    }

    public void printCheque() {
        try {
            if (this.prodArray.length != 0) {
                System.out.println("============================");
                System.out.println(" " + this.name);
                System.out.println("============================");
                for (int i = 0; i < this.prodArray.length; i++) {
                    System.out.printf("%3d", i + 1);
                    System.out.printf("%15s",
                            this.prodArray[i].productName);
                    System.out.printf("%10d",
                            this.prodArray[i].productCost);
                    System.out.println();
                }
                System.out.println("============================");
                System.out.print("Общая стоимость: ");
                System.out.printf("%11d", this.cost);
                System.out.println();
                System.out.println("============================");
            } else {
                System.out.println("\nМассив не создан");
            }
        } catch (NullPointerException e) {
            System.out.println("\nМассив не создан");
        }
    }
}
