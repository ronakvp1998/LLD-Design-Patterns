# Parking Lot System

This is a Low-Level Design (LLD) implementation of a fully functional Parking Lot system. It demonstrates clean architecture, solid object-oriented principles, design patterns (like Strategy and pipeline processing), and thread safety.

## 🚀 Features

### 1. Interactive Command-Line Interface (CLI)
The application includes an interactive shell where users can simulate parking and unparking vehicles, and view the current status of the parking lot.
- **`enter <license>`**: Parks a vehicle and generates a unique ticket.
- **`leave <ticket-id> [payment-method]`**: Exits a vehicle, calculates the total fare based on time parked, and processes the payment (defaults to `cash`, can specify `creditcard`).
- **`status`**: Displays all currently parked vehicles and available spots categorized by size.

### 2. Intelligent Spot Allocation
When a vehicle enters, the `ParkingManager` dynamically finds the most suitable parking spot.
- **Upgrades Allowed:** Vehicles always try to find a spot matching their size (`SMALL`, `MEDIUM`, `LARGE`). If an exact match isn't available, the vehicle will automatically be placed in the next larger available spot (e.g., a `SMALL` motorcycle can park in a `MEDIUM` spot).

### 3. Thread-Safe Operations & Concurrency Design
The core components of the system are designed to be safe for concurrent use, preventing race conditions when multiple cars attempt to enter or exit simultaneously.
- **Why Both `ReentrantLock` and `ConcurrentHashMap`?**
  While `ConcurrentHashMap` ensures thread safety for isolated operations (like `put` or `get`), parking a vehicle is a **compound action** (Check available spots -> Occupy spot -> Update mappings -> Remove from available list). To prevent a "Check-Then-Act" race condition where two threads might try to park in the exact same available spot simultaneously, a `ReentrantLock` acts as a single source of truth. It ensures the entire sequence is atomic and protects the integrity across multiple state structures concurrently.
- `ConcurrentHashMap` and `CopyOnWriteArrayList` are used for managing available spots and active tickets for safe concurrent iteration.

### 4. Flexible Fare Calculation (Strategy Pattern)
The fare calculation leverages a composable Strategy Pattern (acting as a pipeline) to calculate the final amount.
- **Base Fare:** Calculated based on the vehicle's size and the exact duration of the stay (`BaseFareStrategy`). The duration precisely calculates millisecond differentials, ensuring partial hours correctly round up to charge for the full hour.
- **Peak Hours:** Applies a dynamic multiplier (1.5x) if the vehicle entered during designated peak hours (`PeakHoursFareStrategy`).
- **Extensibility:** Because `FareCalculator` loops through a list of `FareStrategy` implementations, new pricing rules (e.g., weekend discounts, VIP waivers) can be added simply by appending a new strategy without modifying existing logic.

### 5. Multiple Payment Methods
The `leaveVehicle` flow supports different payment processors through the `PaymentMethod` interface.
- Supports `CashPayment` and `CreditCardPayment`.
- Payment failure handling is built-in (the vehicle is not unparked if the payment fails).

### 6. Rich Domain Models & Robust State Management
The system models real-world parking lot entities using polymorphism with robust exception handling to prevent invalid states:
- **Spots:** `CompactSpot`, `RegularSpot`, `LargeSpot` (specifically for Trucks), and `HandicappedSpot`. Spots throw `IllegalStateException` if occupied illegally.
- **Vehicles:** `Car`, `MotorCycle`, and `Truck`, each with its designated `VehicleSize`.
- **Leak Prevention:** The `ParkingManager` explicitly prevents duplicate vehicle entries, throwing exceptions if a vehicle is already parked to prevent memory and spot leaks.

## 🏗️ Architecture & Core Classes

- **`Main.java`**: The entry point that acts strictly as the CLI client, delegating all instantiation to specialized factories.
- **`ParkingLot.java`**: The main orchestrator that delegates tasks to the `ParkingManager` and `FareCalculator`.
- **`ParkingManager.java` & `ParkingLotInitializer.java`**: Manages the state of the parking lot, tracks available spots, and sets up the initial default parking domain.
- **`FareCalculator.java` & `FareStrategy.java`**: Evaluates all configured pricing rules and calculates the final cost when a ticket is closed.
- **`Ticket.java`**: Tracks entry time, exit time, and the assigned spot to calculate the duration of the stay.
- **Factories (`PaymentMethodFactory.java`, `VehicleFactory.java`)**: Extracts object creation logic out of the main application flow to adhere to the Single Responsibility Principle and Open/Closed Principle.

## 🛠️ Getting Started

You can run the application directly from your IDE by executing the `main` method in `com.bytebytego.parkinglotproblem.Main`. Once started, use the `help` command in the interactive prompt to see all available actions.
