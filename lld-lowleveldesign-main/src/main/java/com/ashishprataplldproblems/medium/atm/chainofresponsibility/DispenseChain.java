package com.ashishprataplldproblems.medium.atm.chainofresponsibility;

// The chain interface
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(int amount);
    boolean canDispense(int amount);
}
