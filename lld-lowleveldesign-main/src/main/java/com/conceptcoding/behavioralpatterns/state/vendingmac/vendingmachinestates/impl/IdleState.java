package com.conceptcoding.behavioralpatterns.state.vendingmac.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.vendingmac.context.Item;
import com.conceptcoding.behavioralpatterns.state.vendingmac.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmac.vendingmachinestates.State;

import java.util.ArrayList;

public class IdleState extends State {

    public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception{
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
