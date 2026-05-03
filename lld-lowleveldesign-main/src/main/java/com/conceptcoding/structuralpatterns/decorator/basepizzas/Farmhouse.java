package com.conceptcoding.structuralpatterns.decorator.basepizzas;

import com.conceptcoding.structuralpatterns.decorator.BasePizza;

// Step 2: Define the Concrete Component
public class Farmhouse implements BasePizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}
