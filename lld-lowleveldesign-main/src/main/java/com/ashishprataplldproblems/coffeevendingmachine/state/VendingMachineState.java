package com.ashishprataplldproblems.coffeevendingmachine.state;

import com.ashishprataplldproblems.coffeevendingmachine.CoffeeVendingMachine;
import com.ashishprataplldproblems.coffeevendingmachine.decorator.Coffee;

public interface VendingMachineState {
    void selectCoffee(CoffeeVendingMachine machine, Coffee coffee);
    void insertMoney(CoffeeVendingMachine machine, int amount);
    void dispenseCoffee(CoffeeVendingMachine machine);
    void cancel(CoffeeVendingMachine machine);
}
