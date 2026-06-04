package VendingMachineProblem.state;

import VendingMachineProblem.Coin;
import VendingMachineProblem.VendingMachine;

public class IdleState extends VendingMachineState{

    public IdleState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void selectItem(String code) {
        if(!machine.getInventory().isAvailable(code)){
            System.out.println("Item not available");
            return;
        }
        machine.setSelectedItemCode(code);
        machine.setState(new ItemSelectedState(machine));
        System.out.println("Item selected: " + code);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an item before inserting money");
    }

    @Override
    public void dispenseItem() {
        System.out.println("No item selected");
    }

    @Override
    public void refund() {
        System.out.println("no money to refund");
    }
}
