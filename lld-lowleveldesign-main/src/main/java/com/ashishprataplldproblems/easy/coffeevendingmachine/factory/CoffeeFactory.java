package com.ashishprataplldproblems.easy.coffeevendingmachine.factory;

import com.ashishprataplldproblems.easy.coffeevendingmachine.enums.CoffeeType;
import com.ashishprataplldproblems.easy.coffeevendingmachine.templatemethod.Cappuccino;
import com.ashishprataplldproblems.easy.coffeevendingmachine.decorator.Coffee;
import com.ashishprataplldproblems.easy.coffeevendingmachine.templatemethod.Espresso;
import com.ashishprataplldproblems.easy.coffeevendingmachine.templatemethod.Latte;

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
