package com.LLD.DesignPattern.AdapterPattern.Client;

import com.LLD.DesignPattern.AdapterPattern.Adaptee.WeigthMachineForBabies;
import com.LLD.DesignPattern.AdapterPattern.Adapter.WeightMachineAdapter;
import com.LLD.DesignPattern.AdapterPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(
                new WeigthMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
