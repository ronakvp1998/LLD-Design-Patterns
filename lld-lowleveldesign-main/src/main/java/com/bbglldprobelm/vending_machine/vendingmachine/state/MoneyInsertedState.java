package com.bbglldprobelm.vending_machine.vendingmachine.state;

import com.bbglldprobelm.vending_machine.vendingmachine.VendingMachine;

import java.math.BigDecimal;

public class MoneyInsertedState implements VendingMachineState {
    @Override
    public void insertMoney(VendingMachine VM, double amount) {
        VM.getPaymentProcessor().processPayment(new BigDecimal(amount));
    }

    @Override
    public void selectProductByCode(VendingMachine VM, String productCode) throws InvalidStateException {
        try {
            VM.getInventoryManager().getProductInRack(productCode);
            VM.setSelectedProduct(productCode);
            VM.setState(new DispenseState());
        } catch (Exception e) {
            throw new InvalidStateException("Invalid product selection: " + e.getMessage());
        }
    }

    @Override
    public void dispenseProduct(VendingMachine VM) throws InvalidStateException {
        throw new InvalidStateException("Please select a product first.");
    }

    @Override
    public String getStateDescription() {
        return "Money Inserted State";
    }
}
