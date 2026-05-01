package com.practice.Decoratorpattern;

import com.practice.Decoratorpattern.decorator.ExtraCheese;
import com.practice.Decoratorpattern.decorator.Mushroon;

public class Main {

    public static void main(String[] args) {
        BasePizza pizza1 = new ExtraCheese(new Margherita());
        System.out.println(pizza1.cost());

        BasePizza pizza2 = new Mushroon(new ExtraCheese(new Margherita()));
        System.out.println(pizza2.cost());
    }
}
