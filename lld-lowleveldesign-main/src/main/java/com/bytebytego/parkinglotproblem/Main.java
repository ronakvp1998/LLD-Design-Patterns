package com.bytebytego.parkinglotproblem;

import com.bytebytego.parkinglotproblem.fare.BaseFareStrategy;
import com.bytebytego.parkinglotproblem.fare.FareCalculator;
import com.bytebytego.parkinglotproblem.fare.PeakHoursFareStrategy;
import com.bytebytego.parkinglotproblem.fare.Ticket;
import com.bytebytego.parkinglotproblem.spot.CompactSpot;
import com.bytebytego.parkinglotproblem.spot.HandicappedSpot;
import com.bytebytego.parkinglotproblem.spot.ParkingSpot;
import com.bytebytego.parkinglotproblem.spot.ParkingManager;
import com.bytebytego.parkinglotproblem.spot.RegularSpot;
import com.bytebytego.parkinglotproblem.vehicle.Car;
import com.bytebytego.parkinglotproblem.vehicle.Vehicle;
import com.bytebytego.parkinglotproblem.vehicle.VehicleSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<VehicleSize, List<ParkingSpot>> availableSpots = createParkingSpots();
        ParkingManager parkingManager = new ParkingManager(availableSpots);
        FareCalculator fareCalculator = new FareCalculator(
                List.of(new BaseFareStrategy(), new PeakHoursFareStrategy())
        );
        ParkingLot parkingLot = new ParkingLot(parkingManager, fareCalculator);

        Map<String, Ticket> activeTickets = new HashMap<>();
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

    private static Map<VehicleSize, List<ParkingSpot>> createParkingSpots() {
        Map<VehicleSize, List<ParkingSpot>> availableSpots = new HashMap<>();
        availableSpots.put(VehicleSize.SMALL, new ArrayList<>());
        availableSpots.put(VehicleSize.MEDIUM, new ArrayList<>());
        availableSpots.put(VehicleSize.LARGE, new ArrayList<>());

        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(1));
        availableSpots.get(VehicleSize.SMALL).add(new CompactSpot(2));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(3));
        availableSpots.get(VehicleSize.MEDIUM).add(new RegularSpot(4));
        availableSpots.get(VehicleSize.MEDIUM).add(new HandicappedSpot(5));
        availableSpots.get(VehicleSize.MEDIUM).add(new HandicappedSpot(6));

        return availableSpots;
    }

    private static void handleEnter(String[] parts, ParkingLot parkingLot, Map<String, Ticket> activeTickets) {
        if (parts.length < 2) {
            System.out.println("Usage: enter <license-plate>");
            return;
        }

        String licensePlate = parts[1].trim();
        Vehicle vehicle = new Car(licensePlate);
        Ticket ticket = parkingLot.enterVehicle(vehicle);
        if (ticket != null) {
            activeTickets.put(ticket.getTicketId(), ticket);
            System.out.println("Ticket issued: " + ticket.getTicketId());
            System.out.println("Vehicle: " + licensePlate + " parked at spot " + ticket.getParkingSpot().getSpotNumber());
        }
    }

    private static void handleLeave(String[] parts, ParkingLot parkingLot, Map<String, Ticket> activeTickets) {
        if (parts.length < 2) {
            System.out.println("Usage: leave <ticket-id>");
            return;
        }

        String ticketId = parts[1].trim();
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            System.out.println("Ticket not found or already used: " + ticketId);
            return;
        }

        parkingLot.leaveVehicle(ticket);
    }

    private static void printWelcome() {
        System.out.println("Welcome to the Parking Lot CLI!");
        System.out.println("Type 'help' to see command usage.");
        System.out.println();
    }

    private static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  help               - Show this help message");
        System.out.println("  enter <license>    - Park a vehicle and issue a ticket");
        System.out.println("  leave <ticket-id>  - Exit a vehicle and calculate fare");
        System.out.println("  status             - Show active tickets and available spots");
        System.out.println("  quit               - Exit the CLI");
    }

    private static void printStatus(Map<VehicleSize, List<ParkingSpot>> availableSpots, Map<String, Ticket> activeTickets) {
        System.out.println("Active parked vehicles: " + activeTickets.size());
        for (Ticket ticket : activeTickets.values()) {
            System.out.printf("  Ticket=%s, License=%s, Spot=%d, Entry=%s\n",
                    ticket.getTicketId(), ticket.getVehicle().getLicensePlate(), ticket.getParkingSpot().getSpotNumber(), ticket.getEntryTime());
        }

        System.out.println("Available spots:");
        for (VehicleSize size : VehicleSize.values()) {
            System.out.println("  " + size + ": " + availableSpots.get(size).size());
        }
    }
}
