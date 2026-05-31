package com.ashishprataplldproblems.coffeevendingmachine.state;

import com.ashishprataplldproblems.coffeevendingmachine.CoffeeVendingMachine;
import com.ashishprataplldproblems.coffeevendingmachine.decorator.Coffee;

public class OutOfIngredientState implements VendingMachineState {
    @Override
    public void selectCoffee(CoffeeVendingMachine m, Coffee c) {
        System.out.println("Sorry, the machine is out of ingredients.");
    }

    @Override
    public void insertMoney(CoffeeVendingMachine m, int a) {
        System.out.println("Sorry, the machine is out of ingredients. Money refunded.");
    }

    @Override
    public void dispenseCoffee(CoffeeVendingMachine m) {
        System.out.println("Sorry, the machine is out of ingredients.");
    }

    @Override
    public void cancel(CoffeeVendingMachine machine) {
        System.out.println("Refunding " + machine.getMoneyInserted());
        machine.reset();
        machine.setState(new ReadyState());
    }
}
