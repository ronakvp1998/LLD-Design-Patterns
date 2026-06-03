package com.ashishprataplldproblems.easy.coffeevendingmachine.state;

import com.ashishprataplldproblems.easy.coffeevendingmachine.CoffeeVendingMachine;
import com.ashishprataplldproblems.easy.coffeevendingmachine.decorator.Coffee;

public class ReadyState implements VendingMachineState {
    @Override
    public void selectCoffee(CoffeeVendingMachine machine, Coffee coffee) {
        machine.setSelectedCoffee(coffee);
        machine.setState(new SelectingState());
        System.out.println(coffee.getCoffeeType() + " selected. Price: " + coffee.getPrice());
    }

    @Override
    public void insertMoney(CoffeeVendingMachine m, int a) {
        System.out.println("Please select a coffee first.");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine m) {
        System.out.println("Please select and pay first.");
    }

    @Override
    public void cancel(CoffeeVendingMachine m) {
        System.out.println("Nothing to cancel.");
    }
}
