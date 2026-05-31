package com.lldproblems.coffeevendingmachine.state;

import com.lldproblems.coffeevendingmachine.CoffeeVendingMachine;
import com.lldproblems.coffeevendingmachine.decorator.Coffee;

public interface VendingMachineState {
    void selectCoffee(CoffeeVendingMachine machine, Coffee coffee);
    void insertMoney(CoffeeVendingMachine machine, int amount);
    void dispenseCoffee(CoffeeVendingMachine machine);
    void cancel(CoffeeVendingMachine machine);
}
