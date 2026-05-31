package com.ashishprataplldproblems.atm.state;

import com.ashishprataplldproblems.atm.ATMSystem;
import com.ashishprataplldproblems.atm.enums.OperationType;

public interface ATMState {
    void insertCard(ATMSystem atmSystem, String cardNumber);
    void enterPin(ATMSystem atmSystem, String pin);
    void selectOperation(ATMSystem atmSystem, OperationType op, int... args);
    void ejectCard(ATMSystem atmSystem);
}
