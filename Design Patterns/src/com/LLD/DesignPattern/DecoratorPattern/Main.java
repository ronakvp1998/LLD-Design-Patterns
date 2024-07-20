package com.LLD.DesignPattern.DecoratorPattern;

import com.LLD.DesignPattern.DecoratorPattern.Base.BasePizza;
import com.LLD.DesignPattern.DecoratorPattern.Base.Margherita;
import com.LLD.DesignPattern.DecoratorPattern.Decorator.ExtraCheese;
import com.LLD.DesignPattern.DecoratorPattern.Decorator.Mushroom;

public class Main {

    public static void main(String[] args) {

        // Marghetia + Extra Cheese
        BasePizza pizza1 = new ExtraCheese (new Margherita());
        System.out.println(pizza1.cost());      // 100 + 10 = 110

        // Marghetia + Extra Cheese + mushroom
        BasePizza pizza2 = new Mushroom (new ExtraCheese (new Margherita()));
        System.out.println(pizza2.cost());      // 100 + 10 + 15 = 125
    }
}
