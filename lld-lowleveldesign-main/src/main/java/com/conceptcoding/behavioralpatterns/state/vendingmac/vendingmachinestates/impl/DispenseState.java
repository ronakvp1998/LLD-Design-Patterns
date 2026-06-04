package com.conceptcoding.behavioralpatterns.state.vendingmac.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.vendingmac.context.Item;
import com.conceptcoding.behavioralpatterns.state.vendingmac.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmac.vendingmachinestates.State;

public class DispenseState extends State {

    DispenseState(VendingMachine machine, int codeNumber) throws Exception{
        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception{
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }
}

