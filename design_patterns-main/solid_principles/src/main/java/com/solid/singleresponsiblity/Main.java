package com.solid.singleresponsiblity;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // 1 create object of the account
        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("Vishrut");
        account.setTotalAmount(BigDecimal.valueOf(100000));

        // 2 create object of Account Operation
        AccountOperations accountOperations = new AccountOperations();

        // 3 add account to the Account Operation
        accountOperations.addAccount(account);

        // 4 create TransactionOperations obeject
        TransactionOperations transactionOperations = new TransactionOperations();

        // 5 use the deposite methods now
        transactionOperations.deposit(BigDecimal.valueOf(123),123);
    }
}
