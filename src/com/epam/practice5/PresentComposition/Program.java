package com.epam.practice5.PresentComposition;

import com.epam.practice5.PresentComposition.present.Present;
import com.epam.practice5.PresentComposition.present.bouquet.FlowerProvider;
import com.epam.practice5.PresentComposition.presentBuilder.bouquetBuilder.BouquetBuilder;
import com.epam.practice5.PresentComposition.presentBuilder.candySetBuilder.CandySetBuilder;

/**
 * @author Piskunou Yury
 * @my.task Создать консольное приложение, удовлетворяющее следующим требованиям:
•     Корректно спроектируйте и реализуйте предметную область задачи.
•     Для создания объектов из иерархии классов порождающие шаблонов проектирования.
•     Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
•     для проверки корректности переданных данных можно применить регулярные выражения.
•     Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
•     Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().

Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы
и упаковка.

Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
подарок). Составляющими целого подарка являются сладости и упаковка.
 * @since 12.05.21
 */
public class Program { // FLOWER REALIZATION MAINLY
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new CandySetBuilder());
        Present present = director.buildPresent();
        System.out.println(present);

        director.setBuilder(new BouquetBuilder());
        present = director.buildPresent();
        System.out.println(present);
    }
}
