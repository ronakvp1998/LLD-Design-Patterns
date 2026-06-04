package VendingMachineProblem;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // add product to this inventory
        vendingMachine.addItem("A1","coke",25,3);
        vendingMachine.addItem("A2", "Pepsi", 25, 2);
        vendingMachine.addItem("B1", "Water", 10, 5);

        // select a product
        System.out.println("\n Step1: select an item");
        vendingMachine.selectItem("A1");

        // insert coins
        System.out.println("\n Step2: Insert coins");
        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.NICKEL);
        vendingMachine.insertCoin(Coin.NICKEL);

        vendingMachine.refund();

        // Dispense the product
        System.out.println("\n Step3: Dispense item");
        vendingMachine.dispense();

        // trigger refund
        System.out.println("\n Step4: refund");
        vendingMachine.refund();

        // Select another item
        System.out.println("\n--- Step 5: Select another item ---");
        vendingMachine.selectItem("B1");

        // Insert more amount
        System.out.println("\n--- Step 6: Insert more than needed ---");
        vendingMachine.insertCoin(Coin.QUARTER); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 7: Dispense and return change ---");
        vendingMachine.dispense();

    }
}
