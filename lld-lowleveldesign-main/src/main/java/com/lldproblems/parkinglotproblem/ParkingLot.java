package com.lldproblems.parkinglotproblem;

import com.lldproblems.parkinglotproblem.fare.FareCalculator;
import com.lldproblems.parkinglotproblem.fare.Ticket;
import com.lldproblems.parkinglotproblem.spot.ParkingManager;
import com.lldproblems.parkinglotproblem.spot.ParkingSpot;
import com.lldproblems.parkinglotproblem.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingLot {

    // manages parking spots and vehicle assignments
    private final ParkingManager parkingManager;
    // calculates fare for parking sessions
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    private static String generateTicketId(){
        return UUID.randomUUID().toString();
    }

    // Method to handle vehicle entry into the parking lot
    public Ticket enterVehicle(Vehicle vehicle){
        ParkingSpot spot;
        try {
            // Delegate parking logic to ParkingManager
            spot = parkingManager.parkVehicle(vehicle);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage() + ": " + vehicle.getLicensePlate());
            return null;
        }
        
        if(spot != null){
            // create ticket with entry time
            Ticket ticket = new Ticket(generateTicketId(),vehicle,spot, LocalDateTime.now());
            return ticket;
        }else{
            System.out.println("No available spots for vehicle: " + vehicle.getLicensePlate());
            return null;
        }
    }

    // Method to handle vehicle exit from the parking lot
    public void leaveVehicle(Ticket ticket, com.lldproblems.parkinglotproblem.payment.PaymentMethod paymentMethod){
        // Ensue the ticket is valid and the vehicle hasn't already left
        if(ticket != null && ticket.getExitTime() == null){
            // set exit time
            ticket.setExitTime(LocalDateTime.now());
            // calculate the fare
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            
            // process payment
            boolean isPaid = paymentMethod.processPayment(fare);
            
            if (isPaid) {
                // Delegate unparking logic to ParkingManager
                parkingManager.unparkVehicle(ticket.getVehicle());
                System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() +
                        " has left. total fare: $ " + fare);
            } else {
                System.out.println("Payment failed. Vehicle cannot exit.");
                ticket.setExitTime(null); // Revert exit time
            }
        }else{
            System.out.println("Invalid ticket or vehicle already exited");
        }
    }
}
