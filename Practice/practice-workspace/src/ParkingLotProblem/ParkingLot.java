package ParkingLotProblem;

import ParkingLotProblem.fare.FareCalculator;
import ParkingLotProblem.fare.Ticket;
import ParkingLotProblem.payment.PaymentMethod;
import ParkingLotProblem.spot.ParkingManager;
import ParkingLotProblem.spot.ParkingSpot;
import ParkingLotProblem.vehicle.Vehicle;
import ParkingLotProblem.vehicle.VehicleFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator) {
        this.parkingManager = parkingManager;
        this.fareCalculator = fareCalculator;
    }

    private static String generateTicketId(){
        return UUID.randomUUID().toString();
    }

    public Ticket enterVehicle(Vehicle vehicle){
        ParkingSpot spot;
        try {
            spot = parkingManager.parkVehicle(vehicle);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage() + " : " + vehicle.getLicensePlate());
            return null;
        }

        if(spot != null){
            Ticket ticket = new Ticket(generateTicketId(),vehicle,spot, LocalDateTime.now());
            return ticket;
        }else{
            System.out.println("No available spots for vehicle " + vehicle.getLicensePlate());
            return null;
        }
    }

    public void leaveVehicle(Ticket ticket, PaymentMethod paymentMethod){
        if(ticket != null && ticket.getExitTime() == null){
            ticket.setExitTime(LocalDateTime.now());
            BigDecimal fare = fareCalculator.calculateFare(ticket);
            boolean isPaid = paymentMethod.processPayment(fare);
            if(isPaid){
                parkingManager.unparkVehicle(ticket.getVehicle());
                System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " has left total fare " + fare);
            }else{
                System.out.println("Payment failed vehicle cannot exit");
                ticket.setExitTime(null);
            }
        }else{
            System.out.println("Invalid ticket or vehicle already exited");
        }
    }
}
