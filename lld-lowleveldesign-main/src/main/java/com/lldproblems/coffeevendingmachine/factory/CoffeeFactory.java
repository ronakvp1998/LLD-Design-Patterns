package com.lldproblems.coffeevendingmachine.factory;

import com.lldproblems.coffeevendingmachine.enums.CoffeeType;
import com.lldproblems.coffeevendingmachine.templatemethod.Cappuccino;
import com.lldproblems.coffeevendingmachine.decorator.Coffee;
import com.lldproblems.coffeevendingmachine.templatemethod.Espresso;
import com.lldproblems.coffeevendingmachine.templatemethod.Latte;

public class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case ESPRESSO:
                return new Espresso();
            case LATTE:
                return new Latte();
            case CAPPUCCINO:
                return new Cappuccino();
            default:
                throw new IllegalArgumentException("Unsupported coffee type: " + type);
        }
    }
}
