package com.LLD.DesignPattern.DecoratorPattern.Decorator;

import com.LLD.DesignPattern.DecoratorPattern.Base.BasePizza;

public class ExtraCheese extends ToppingDecorator{
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return this.pizza.cost() + 10;
    }
}
