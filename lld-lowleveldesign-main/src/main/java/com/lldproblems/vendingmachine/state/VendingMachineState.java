package com.lldproblems.vendingmachine.state;

import com.lldproblems.vendingmachine.enums.Coin;
import com.lldproblems.vendingmachine.VendingMachine;

public abstract class VendingMachineState {
    VendingMachine machine;

    VendingMachineState(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();
}