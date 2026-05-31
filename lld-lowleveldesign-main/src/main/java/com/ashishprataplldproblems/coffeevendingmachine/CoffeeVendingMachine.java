package com.ashishprataplldproblems.coffeevendingmachine;


import com.ashishprataplldproblems.coffeevendingmachine.decorator.CaramelSyrupDecorator;
import com.ashishprataplldproblems.coffeevendingmachine.decorator.ExtraSugarDecorator;
import com.ashishprataplldproblems.coffeevendingmachine.enums.CoffeeType;
import com.ashishprataplldproblems.coffeevendingmachine.enums.ToppingType;
import com.ashishprataplldproblems.coffeevendingmachine.factory.CoffeeFactory;
import com.ashishprataplldproblems.coffeevendingmachine.state.ReadyState;
import com.ashishprataplldproblems.coffeevendingmachine.state.VendingMachineState;
import com.ashishprataplldproblems.coffeevendingmachine.decorator.Coffee;

import java.util.List;

public class CoffeeVendingMachine {
    private static final CoffeeVendingMachine INSTANCE = new CoffeeVendingMachine();
    private VendingMachineState state;
    private Coffee selectedCoffee;
    private int moneyInserted;

    private CoffeeVendingMachine() {
        this.state = new ReadyState();
        this.moneyInserted = 0;
    }

    public static CoffeeVendingMachine getInstance() {
        return INSTANCE;
    }

    // --- Actions delegated to the current state ---
    public void selectCoffee(CoffeeType type, List<ToppingType> toppings) {
        // 1. Create the base coffee using the factory
        Coffee coffee = CoffeeFactory.createCoffee(type);

        // 2. Wrap it with decorators
        for (ToppingType topping : toppings) {
            switch (topping) {
                case EXTRA_SUGAR:
                    coffee = new ExtraSugarDecorator(coffee);
                    break;
                case CARAMEL_SYRUP:
                    coffee = new CaramelSyrupDecorator(coffee);
                    break;
            }
        }
        // Let the state handle the rest
        this.state.selectCoffee(this, coffee);
    }

    public void insertMoney(int amount) { state.insertMoney(this, amount); }
    public void dispenseCoffee() { state.dispenseCoffee(this); }
    public void cancel() { state.cancel(this); }

    // --- Getters and Setters used by State objects ---
    public void setState(VendingMachineState state) { this.state = state; }
    public VendingMachineState getState() { return state; }
    public void setSelectedCoffee(Coffee selectedCoffee) { this.selectedCoffee = selectedCoffee; }
    public Coffee getSelectedCoffee() { return selectedCoffee; }
    public void setMoneyInserted(int moneyInserted) { this.moneyInserted = moneyInserted; }
    public int getMoneyInserted() { return moneyInserted; }

    public void reset() {
        this.selectedCoffee = null;
        this.moneyInserted = 0;
    }

}
