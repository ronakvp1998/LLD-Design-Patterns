package com.LLD.DesignPattern.DecoratorPattern.Decorator;

import com.LLD.DesignPattern.DecoratorPattern.Base.BasePizza;

public class Mushroom extends ToppingDecorator{

    BasePizza pizza;

    public Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        return this.pizza.cost() + 15;
    }
}
