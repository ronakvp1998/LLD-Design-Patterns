package VendingMachineProblem.state;

import VendingMachineProblem.VendingMachine;
import VendingMachineProblem.Coin;

public abstract class VendingMachineState {
    VendingMachine machine;

    public VendingMachineState(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void selectItem(String code);
    public abstract void insertCoin(Coin coin);
    public abstract void dispenseItem();
    public abstract void refund();

}
