package com.LLD.DesignPattern.AdapterPattern.Adapter;

import com.LLD.DesignPattern.AdapterPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{

    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg(){
        double weightInPound = weightMachine.getWeightInPound();

        // convert it to kg's
        double weightInKg = weightInPound * .45;
        return weightInKg;
    }
}
