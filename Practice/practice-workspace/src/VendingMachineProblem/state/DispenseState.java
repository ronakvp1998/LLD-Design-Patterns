package VendingMachineProblem.state;

import VendingMachineProblem.Coin;
import VendingMachineProblem.VendingMachine;

public class DispenseState extends VendingMachineState{

    public DispenseState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("Currently dispensing. Please wait.");
        machine.dispenseItem();
    }

    @Override
    public void refund() {
        machine.reset();
        machine.setState(new IdleState(machine));
    }
}
