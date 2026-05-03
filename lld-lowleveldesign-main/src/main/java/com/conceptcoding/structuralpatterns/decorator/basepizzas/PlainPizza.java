package com.conceptcoding.structuralpatterns.decorator.basepizzas;

import com.conceptcoding.structuralpatterns.decorator.BasePizza;

// Step 2: Define the Concrete Component
public class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }
}