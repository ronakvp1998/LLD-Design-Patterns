package com.bytebytego.parkinglotproblem;

import com.bytebytego.parkinglotproblem.fare.BaseFareStrategy;
import com.bytebytego.parkinglotproblem.fare.FareCalculator;
import com.bytebytego.parkinglotproblem.fare.PeakHoursFareStrategy;
import com.bytebytego.parkinglotproblem.fare.Ticket;
import com.bytebytego.parkinglotproblem.payment.PaymentMethod;
import com.bytebytego.parkinglotproblem.payment.PaymentMethodFactory;
import com.bytebytego.parkinglotproblem.spot.ParkingSpot;
import com.bytebytego.parkinglotproblem.spot.ParkingManager;
import com.bytebytego.parkinglotproblem.spot.ParkingLotInitializer;
import com.bytebytego.parkinglotproblem.vehicle.Vehicle;
import com.bytebytego.parkinglotproblem.vehicle.VehicleFactory;
import com.bytebytego.parkinglotproblem.vehicle.VehicleSize;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<VehicleSize, List<ParkingSpot>> availableSpots = ParkingLotInitializer.createDefaultSpots();
        ParkingManager parkingManager = new ParkingManager(availableSpots);
        FareCalculator fareCalculator = new FareCalculator(
                List.of(new BaseFareStrategy(), new PeakHoursFareStrategy())
        );
        ParkingLot parkingLot = new ParkingLot(parkingManager, fareCalculator);

        Map<String, Ticket> activeTickets = new java.util.concurrent.ConcurrentHashMap<>();
        Scanner scanner = new Scanner(System.in);

        printWelcome();

        while (true) {
            System.out.print("parking-lot> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "help", "h" -> printHelp();
                case "enter", "park" -> handleEnter(parts, parkingLot, activeTickets);
                case "leave", "exit" -> handleLeave(parts, parkingLot, activeTickets);
                case "status" -> printStatus(availableSpots, activeTickets);
                case "quit", "q", "bye" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Unknown command. Type 'help' to see available commands.");
            }
        }
    }

    private static void handleEnter(String[] parts, ParkingLot parkingLot, Map<String, Ticket> activeTickets) {
        if (parts.length < 2) {
            System.out.println("Usage: enter <license-plate> [car|motorcycle|truck]");
            return;
        }

        String licensePlate = parts[1].trim();
        String vehicleType = parts.length >= 3 ? parts[2].trim() : "car";
        Vehicle vehicle = VehicleFactory.createVehicle(licensePlate, vehicleType);
        
        Ticket ticket = parkingLot.enterVehicle(vehicle);
        if (ticket != null) {
            activeTickets.put(ticket.getTicketId(), ticket);
            System.out.println("Ticket issued: " + ticket.getTicketId());
            System.out.println("Vehicle: " + licensePlate + " (" + vehicle.getSize() + ") parked at spot " + ticket.getParkingSpot().getSpotNumber() + " floor " + ticket.getParkingSpot().getFloor());
        }
    }

    private static void handleLeave(String[] parts, ParkingLot parkingLot, Map<String, Ticket> activeTickets) {
        if (parts.length < 2) {
            System.out.println("Usage: leave <ticket-id> [cash|creditcard] [name] [cardNumber]");
            return;
        }

        String ticketId = parts[1].trim();
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Ticket not found or already used: " + ticketId);
            return;
        }

        String paymentType = parts.length >= 3 ? parts[2] : "cash";
        String nameOnCard = null;
        String cardNumber = null;

        PaymentMethod paymentMethod = null;
        
        if (paymentType.equalsIgnoreCase("creditcard")) {
            if (parts.length < 5) {
                System.out.println("Usage for credit card: leave <ticket-id> creditcard <name> <cardNumber>");
                return;
            }
            cardNumber = parts[parts.length - 1];
            StringBuilder nameBuilder = new StringBuilder();
            for (int i = 3; i < parts.length - 1; i++) {
                nameBuilder.append(parts[i]).append(" ");
            }
            nameOnCard = nameBuilder.toString().trim();
            paymentMethod = PaymentMethodFactory.getPaymentMethod(paymentType, nameOnCard, cardNumber);
        }

        if (paymentType.equalsIgnoreCase("cash") || paymentMethod == null) {
            paymentMethod = PaymentMethodFactory.getPaymentMethod(paymentType);
        }   

        parkingLot.leaveVehicle(ticket, paymentMethod);
        if (ticket.getExitTime() != null) {
            activeTickets.remove(ticketId);
        }
    }

    private static void printWelcome() {
        System.out.println("Welcome to the Parking Lot CLI!");
        System.out.println("Type 'help' to see command usage.");
        System.out.println();
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  help               - Show this help message");
        System.out.println("  enter <license> [type] - Park a vehicle (car|motorcycle|truck) and issue a ticket");
        System.out.println("  leave <ticket-id> [payment-method] [name] [card-number] - Exit a vehicle and calculate fare (cash|creditcard)");
        System.out.println("  status             - Show active tickets and available spots");
        System.out.println("  quit               - Exit the CLI");
    }

    private static void printStatus(Map<VehicleSize, List<ParkingSpot>> availableSpots, Map<String, Ticket> activeTickets) {
        System.out.println("Active parked vehicles: " + activeTickets.size());
        for (Ticket ticket : activeTickets.values()) {
            System.out.printf("  Ticket=%s, License=%s, Floor=%d, Spot=%d, Entry=%s\n",
                    ticket.getTicketId(), ticket.getVehicle().getLicensePlate(), ticket.getParkingSpot().getFloor(), ticket.getParkingSpot().getSpotNumber(), ticket.getEntryTime());
        }

        System.out.println("Available spots:");
        for (VehicleSize size : VehicleSize.values()) {
            System.out.println("  " + size + ": " + availableSpots.get(size).size());
        }
    }
}
