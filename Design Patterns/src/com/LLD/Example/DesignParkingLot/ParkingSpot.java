package com.LLD.Example.DesignParkingLot;

// Has-A
// 1 Vehicle

public class ParkingSpot {
    int id;
    Boolean isEmpty;
    Vehicle vehicle;
    int price;

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle(){
        vehicle = null;
        isEmpty = true;
    }

    public int price(){
        return 10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
