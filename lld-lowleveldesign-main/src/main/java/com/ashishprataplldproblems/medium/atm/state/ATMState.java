package com.ashishprataplldproblems.medium.atm.state;

import com.ashishprataplldproblems.medium.atm.ATMSystem;
import com.ashishprataplldproblems.medium.atm.enums.OperationType;

public interface ATMState {
    void insertCard(ATMSystem atmSystem, String cardNumber);
    void enterPin(ATMSystem atmSystem, String pin);
    void selectOperation(ATMSystem atmSystem, OperationType op, int... args);
    void ejectCard(ATMSystem atmSystem);
}
