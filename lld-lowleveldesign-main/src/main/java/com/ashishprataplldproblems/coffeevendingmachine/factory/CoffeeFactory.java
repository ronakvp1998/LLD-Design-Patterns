package com.ashishprataplldproblems.coffeevendingmachine.factory;

import com.ashishprataplldproblems.coffeevendingmachine.enums.CoffeeType;
import com.ashishprataplldproblems.coffeevendingmachine.templatemethod.Cappuccino;
import com.ashishprataplldproblems.coffeevendingmachine.decorator.Coffee;
import com.ashishprataplldproblems.coffeevendingmachine.templatemethod.Espresso;
import com.ashishprataplldproblems.coffeevendingmachine.templatemethod.Latte;

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
