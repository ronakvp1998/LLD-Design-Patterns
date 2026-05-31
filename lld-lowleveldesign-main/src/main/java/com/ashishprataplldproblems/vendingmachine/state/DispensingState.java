package com.ashishprataplldproblems.vendingmachine.state;

import com.ashishprataplldproblems.vendingmachine.enums.Coin;
import com.ashishprataplldproblems.vendingmachine.VendingMachine;

public class DispensingState extends VendingMachineState {
    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispense() {
        // already triggered by HasMoneyState
    }

    @Override
    public void refund() {
        System.out.println("Dispensing in progress. Refund not allowed.");
    }
}
