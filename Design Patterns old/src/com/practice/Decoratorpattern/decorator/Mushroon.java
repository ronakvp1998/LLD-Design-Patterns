package com.practice.Decoratorpattern.decorator;

import com.practice.Decoratorpattern.BasePizza;

public class Mushroon extends ToppingDecorator{

    BasePizza basePizza;

    public Mushroon(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 15;
    }
}
