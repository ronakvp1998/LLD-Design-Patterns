package VendingMachineProblem.state;

import VendingMachineProblem.Coin;
import VendingMachineProblem.VendingMachine;

public class HasMoneyState extends VendingMachineState{

    public HasMoneyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received full amount");
    }

    @Override
    public void dispenseItem() {
        machine.setState(new DispenseState(machine));
        machine.dispense();
    }

    @Override
    public void refund() {
        System.out.println("refund " + machine.getBalance());
        machine.reset();
        machine.setState(new IdleState(machine));
    }
}
