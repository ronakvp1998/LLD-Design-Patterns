package com.ashishprataplldproblems.easy.coffeevendingmachine.state;

import com.ashishprataplldproblems.easy.coffeevendingmachine.CoffeeVendingMachine;
import com.ashishprataplldproblems.easy.coffeevendingmachine.decorator.Coffee;

public interface VendingMachineState {
    void selectCoffee(CoffeeVendingMachine machine, Coffee coffee);
    void insertMoney(CoffeeVendingMachine machine, int amount);
    void dispenseCoffee(CoffeeVendingMachine machine);
    void cancel(CoffeeVendingMachine machine);
}
