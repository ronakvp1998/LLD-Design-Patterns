# Detailed Class Diagrams`n`nThis file contains detailed Mermaid class diagrams with fields, methods, and relationships for the main repository topics. Use it for interview revision.`n`n
## additionalpatterns\.mvc

```mermaid
classDiagram
    class BlogController
    {
        +view: BlogView
    }
    class Blog
    {
        +title: String
        +content: String
        +author: String
        +createdAt: Date
    }
    class MVCPatternDemo
    {
    }
    class BlogView
    {
    }
    BlogController o-- BlogView : has-a
```


## additionalpatterns\.nullobject

```mermaid
classDiagram
    class Bike
    {
        +model: String
        +color: String
        +seatingCapacity: int
        +fuelTankCapacity: int
        +isAvailableForTestDrive: boolean
    }
    class Car
    {
        +model: String
        +color: String
        +seatingCapacity: int
        +fuelTankCapacity: int
        +isAvailableForTestDrive: boolean
    }
    class ProblemDemo
    {
    }
    class VehicleFactory
    {
    }
    class NullVehicle
    {
        +model: String
        +color: String
        +seatingCapacity: int
        +fuelTankCapacity: int
        +isAvailableForTestDrive: boolean
    }
    class SolutionDemo
    {
    }
    class VehicleFactory
    {
    }
    class Vehicle
    {
        +start(): void
        +stop(): void
    }
    Vehicle <|-- Bike : is-a
    Vehicle <|-- Car : is-a
    Vehicle <|-- NullVehicle : is-a
```


## behavioralpatterns\.chainofresponsibility

```mermaid
classDiagram
    class DebugLogProcessor
    {
    }
    class ErrorLogProcessor
    {
    }
    class FatalLogProcessor
    {
    }
    class InfoLogProcessor
    {
    }
    class LoggerDemo
    {
    }
    class LogProcessor
    {
        +level: int
        +nextLoggerProcessor: LogProcessor
        +write(String message): protected void
    }
    LogProcessor <|-- DebugLogProcessor : is-a
    LogProcessor <|-- ErrorLogProcessor : is-a
    LogProcessor <|-- FatalLogProcessor : is-a
    LogProcessor <|-- InfoLogProcessor : is-a
```


## behavioralpatterns\.command\.solution

```mermaid
classDiagram
    class AirConditioner
    {
        +isOn: boolean
        +temperature: int
    }
    class Client
    {
    }
    class ICommand <<interface>>
    {
        +execute(): void
        +undo(): void
    }
    class RemoteController
    {
    }
    class SetTemperatureCommand
    {
        +ac: AirConditioner
        +newTemperature: int
        +previousTemperature: int
    }
    class TurnOffCommand
    {
        +ac: AirConditioner
        +previousState: boolean
    }
    class TurnOnCommand
    {
        +ac: AirConditioner
        +previousState: boolean
    }
    ICommand <|.. SetTemperatureCommand : implements
    SetTemperatureCommand o-- AirConditioner : has-a
    ICommand <|.. TurnOffCommand : implements
    TurnOffCommand o-- AirConditioner : has-a
    ICommand <|.. TurnOnCommand : implements
    TurnOnCommand o-- AirConditioner : has-a
```


## behavioralpatterns\.interpreter

```mermaid
classDiagram
    class AbstractExpression <<interface>>
    {
        +interpret(Context context): int
    }
    class AddNonTerminalExpression
    {
        +rightExpression: AbstractExpression
        +leftExpression: AbstractExpression
    }
    class BinaryNonTerminalExpression
    {
        +leftExpression: AbstractExpression
        +rightExpression: AbstractExpression
        +operator: char
    }
    class Client
    {
    }
    class Context
    {
    }
    class MultiplyNonTerminalExpression
    {
        +leftExpression: AbstractExpression
        +rightExpression: AbstractExpression
    }
    class NumberTerminalExpression
    {
        +stringValue: String
    }
    AbstractExpression <|.. AddNonTerminalExpression : implements
    AddNonTerminalExpression o-- AbstractExpression : has-a
    AbstractExpression <|.. BinaryNonTerminalExpression : implements
    BinaryNonTerminalExpression o-- AbstractExpression : has-a
    AbstractExpression <|.. MultiplyNonTerminalExpression : implements
    MultiplyNonTerminalExpression o-- AbstractExpression : has-a
    AbstractExpression <|.. NumberTerminalExpression : implements
```


## behavioralpatterns\.iterator\.library

```mermaid
classDiagram
    class Book
    {
        +title: String
        +author: String
        +isbn: String
        +price: int
    }
    class BookCollection <<interface>>
    {
        +createIterator(): Iterator<Book>
        +createReverseIterator(): Iterator<Book>
    }
    class Iterator <<interface>>
    {
        +hasNext(): boolean
        +next(): T
    }
    class Library
    {
        +books: List<Book>
    }
    class LibraryIterator
    {
        +books: List<Book>
    }
    class LibraryIteratorDemo
    {
    }
    class ReverseLibraryIterator
    {
        +books: List<Book>
        +position: int
    }
    BookCollection <|.. Library : implements
    Iterator <|.. LibraryIterator : implements
    Iterator <|.. ReverseLibraryIterator : implements
```


## behavioralpatterns\.mediator

```mermaid
classDiagram
    class AuctionDemo
    {
    }
    class AuctionHouse
    {
        +bidders: List<IColleague>
        +itemName: String
        +currentHighestBid: double
        +currentHighestBidder: IColleague
    }
    class AuctionMediator <<interface>>
    {
        +registerBidder(IColleague bidder): void
        +placeBid(IColleague bidder, double bidAmount): void
        +closeAuction(): void
    }
    class Bidder
    {
        +name: String
        +mediator: AuctionMediator
    }
    class IColleague <<interface>>
    {
        +placeBid(double amount): void
        +receiveBidNotification(double bidAmount): void
        +getName(): String
    }
    AuctionMediator <|.. AuctionHouse : implements
    AuctionHouse o-- IColleague : has-a
    IColleague <|.. Bidder : implements
    Bidder o-- AuctionMediator : has-a
```


## behavioralpatterns\.memento

```mermaid
classDiagram
    class ApplicationConfiguration
    {
        +theme: String
        +fontSize: int
        +notificationsEnabled: boolean
        +language: String
    }
    class ConfigurationManager
    {
    }
    class ConfigurationMemento
    {
        +theme: String
        +fontSize: int
        +notificationsEnabled: boolean
        +language: String
    }
    class MementoDemo
    {
    }
```


## behavioralpatterns\.observer\.notifymefeature

```mermaid
classDiagram
    class ECommerceStockNotificationApp
    {
    }
    class IphoneProductObservable
    {
        +productId: String
        +productName: String
        +price: double
        +stockObservers: List<StockNotificationObserver>
        +stockQuantity: int
    }
    class StockAvailabilityObservable <<interface>>
    {
        +addStockObserver(StockNotificationObserver observer): void
        +removeStockObserver(StockNotificationObserver observer): void
        +notifyStockObservers(): void
        +purchase(int quantity): boolean
        +restock(int quantity): void
    }
    class EmailNotificationObserver
    {
        +userId: String
        +emailAddress: String
    }
    class PushNotificationObserver
    {
        +userId: String
        +deviceToken: String
    }
    class StockNotificationObserver <<interface>>
    {
        +update(): void
        +getNotificationMethod(): String
        +getUserId(): String
    }
    StockAvailabilityObservable <|.. IphoneProductObservable : implements
    StockNotificationObserver <|.. EmailNotificationObserver : implements
    StockNotificationObserver <|.. PushNotificationObserver : implements
```


## behavioralpatterns\.observer\.weatherstation

```mermaid
classDiagram
    class WeatherObservable <<interface>>
    {
        +addObserver(WeatherObserver observer): void
        +removeObserver(WeatherObserver observer): void
        +notifyObservers(): void
        +setWeatherReadings(float temperature, float humidity, float pressure): void
    }
    class WeatherStation
    {
        +observers: List<WeatherObserver>
        +temperature: float
        +humidity: float
        +pressure: float
    }
    class CurrentConditionsDisplay
    {
        +weatherStation: WeatherObservable
    }
    class ForecastDisplay
    {
        +weatherStation: WeatherObservable
    }
    class WeatherObserver <<interface>>
    {
        +update(): void
    }
    class WeatherStationApp
    {
    }
    WeatherObservable <|.. WeatherStation : implements
    WeatherObserver <|.. CurrentConditionsDisplay : implements
    CurrentConditionsDisplay o-- WeatherObservable : has-a
    WeatherObserver <|.. ForecastDisplay : implements
    ForecastDisplay o-- WeatherObservable : has-a
```


## behavioralpatterns\.state

```mermaid
classDiagram
    class Inventory
    {
    }
    class Item
    {
        +type: ItemType
        +price: int
    }
    class ItemShelf
    {
        +code: int
        +item: Item
        +soldOut: boolean
    }
    class ItemType <<enum>>
    {
    }
    class VendingMachine
    {
        +vendingMachineState: State
        +inventory: Inventory
        +coinList: List<Coin>
    }
    class VendingMachineAppDemo
    {
    }
    class Coin <<enum>>
    {
        +value: int
    }
    class DispenseState
    {
    }
    class HasMoneyState
    {
    }
    class IdleState
    {
    }
    class SelectionState
    {
    }
    class State
    {
    }
    Item o-- ItemType : has-a
    ItemShelf o-- Item : has-a
    VendingMachine o-- State : has-a
    VendingMachine o-- Inventory : has-a
    State <|-- DispenseState : is-a
    State <|-- HasMoneyState : is-a
    State <|-- IdleState : is-a
    State <|-- SelectionState : is-a
```


## behavioralpatterns\.strategy\.paymentmethods\.solution

```mermaid
classDiagram
    class Demo
    {
    }
    class ShoppingCart
    {
        +paymentStrategy: PaymentStrategy
    }
    class CreditCardPayment
    {
        +cardNumber: String
    }
    class PaymentStrategy <<interface>>
    {
        +pay(double amount): void
    }
    class PayPalPayment
    {
        +email: String
    }
    class UPIPayment
    {
        +upiId: String
    }
    ShoppingCart o-- PaymentStrategy : has-a
    PaymentStrategy <|.. CreditCardPayment : implements
    PaymentStrategy <|.. PayPalPayment : implements
    PaymentStrategy <|.. UPIPayment : implements
```


## behavioralpatterns\.strategy\.vehicledrivemodes\.solution

```mermaid
classDiagram
    class GoodsVehicle
    {
    }
    class HybridVehicle
    {
    }
    class OffRoadVehicle
    {
    }
    class SportsVehicle
    {
    }
    class Vehicle
    {
        +driveStrategy: DriveStrategy
    }
    class Demo
    {
    }
    class DriveStrategy <<interface>>
    {
        +drive(): void
    }
    class EVDrive
    {
    }
    class NormalDrive
    {
    }
    class SportsDrive
    {
    }
    Vehicle <|-- GoodsVehicle : is-a
    Vehicle <|-- HybridVehicle : is-a
    Vehicle <|-- OffRoadVehicle : is-a
    Vehicle <|-- SportsVehicle : is-a
    Vehicle o-- DriveStrategy : has-a
    DriveStrategy <|.. EVDrive : implements
    DriveStrategy <|.. NormalDrive : implements
    DriveStrategy <|.. SportsDrive : implements
```


## behavioralpatterns\.templatemethod

```mermaid
classDiagram
    class BankTransfer
    {
    }
    class MerchantPayment
    {
    }
    class PaymentFlow
    {
        +validateRequest(): void
        +debitAmount(): void
        +calculateFees(): void
        +creditAmount(): void
    }
    class TemplateDemo
    {
    }
    PaymentFlow <|-- BankTransfer : is-a
    PaymentFlow <|-- MerchantPayment : is-a
```


## behavioralpatterns\.visitor\.solution

```mermaid
classDiagram
    class DeluxeRoom
    {
        +roomNumber: String
        +hasJacuzzi: boolean
    }
    class IRoom <<interface>>
    {
        +accept(IRoomVisitor visitor): void
    }
    class StandardRoom
    {
        +roomNumber: String
    }
    class SuiteRoom
    {
        +roomNumber: String
        +numberOfRooms: int
    }
    class HotelVisitorDemo
    {
    }
    class HousekeepingVisitor
    {
    }
    class IRoomVisitor <<interface>>
    {
        +visitStandardRoom(StandardRoom room): void
        +visitDeluxeRoom(DeluxeRoom room): void
        +visitSuiteRoom(SuiteRoom room): void
    }
    class PricingVisitor
    {
    }
    class RoomServiceVisitor
    {
        +orderDetails: String
    }
    IRoom <|.. DeluxeRoom : implements
    IRoom <|.. StandardRoom : implements
    IRoom <|.. SuiteRoom : implements
    IRoomVisitor <|.. HousekeepingVisitor : implements
    IRoomVisitor <|.. PricingVisitor : implements
    IRoomVisitor <|.. RoomServiceVisitor : implements
```


## creationalpatterns\.abstractfactory

```mermaid
classDiagram
    class AbstractFactoryDemo
    {
    }
    class CarExterior <<interface>>
    {
        +addExteriorComponents(): void
    }
    class CarFactory <<interface>>
    {
        +createInterior(): CarInterior
        +createExterior(): CarExterior
    }
    class CarType <<enum>>
    {
    }
    class CarInterior <<interface>>
    {
        +addInteriorComponents(): void
    }
    class EconomyCarExterior
    {
    }
    class EconomyCarFactory
    {
        +brand: String
    }
    class EconomyCarInterior
    {
    }
    class LuxuryCarExterior
    {
    }
    class LuxuryCarFactory
    {
        +brand: String
    }
    class LuxuryCarInterior
    {
    }
    CarExterior <|.. EconomyCarExterior : implements
    CarFactory <|.. EconomyCarFactory : implements
    CarInterior <|.. EconomyCarInterior : implements
    CarExterior <|.. LuxuryCarExterior : implements
    CarFactory <|.. LuxuryCarFactory : implements
    CarInterior <|.. LuxuryCarInterior : implements
```


## creationalpatterns\.builder\.solution

```mermaid
classDiagram
    class Client
    {
    }
    class EngineeringStudentBuilder
    {
    }
    class MBAStudentBuilder
    {
    }
    class Student
    {
        +rollNumber: int
        +age: int
        +name: String
        +branch: String
        +fatherName: String
        +motherName: String
        +subjects: List<String>
        +mobileNo: String
        +emailId: String
    }
    class StudentBuilder
    {
        +rollNumber: int
        +age: int
        +name: String
        +branch: String
        +fatherName: String
        +motherName: String
        +subjects: List<String>
        +mobileNo: String
        +emailId: String
        +setSubjects(): public StudentBuilder
    }
    class StudentRegistrationDirector
    {
        +studentBuilder: StudentBuilder
    }
    StudentBuilder <|-- EngineeringStudentBuilder : is-a
    StudentBuilder <|-- MBAStudentBuilder : is-a
    StudentRegistrationDirector o-- StudentBuilder : has-a
```


## creationalpatterns\.factory\.factorymethod

```mermaid
classDiagram
    class CircleCreator
    {
    }
    class FactoryMethodDemo
    {
    }
    class RectangleCreator
    {
    }
    class ShapeFactory
    {
        +createShape(): Shape
    }
    class SquareCreator
    {
    }
    ShapeFactory <|-- CircleCreator : is-a
    ShapeFactory <|-- RectangleCreator : is-a
    ShapeFactory <|-- SquareCreator : is-a
```


## creationalpatterns\.factory\.simplefactory

```mermaid
classDiagram
    class ShapeFactory
    {
    }
    class SimpleFactoryDemo
    {
    }
```


## creationalpatterns\.objectpool\.solution

```mermaid
classDiagram
    class Client
    {
    }
    class DBConnectionPoolManager
    {
    }
```


## creationalpatterns\.prototype\.solution

```mermaid
classDiagram
    class DemoSolution
    {
    }
    class Student
    {
        +id: int
        +name: String
        +branch: String
        +inHighSchool: boolean
        +rollNo: int
    }
    class StudentPrototype <<interface>>
    {
        +clone(): StudentPrototype
    }
    StudentPrototype <|.. Student : implements
```


## creationalpatterns\.singleton

```mermaid
classDiagram
    class DBConnectionDoubleLocking
    {
    }
    class DBConnectionEager
    {
    }
    class DBConnectionLazy
    {
    }
    class DBConnectionThreadSafe
    {
    }
    class DBConnectionDoubleCheckedLockFix
    {
        +portNumber: int
    }
    class DBConnectionDoubleCheckedLockIssue
    {
        +portNumber: int
    }
    class SingletonDemo
    {
    }
```


## structuralpatterns\.adapter

```mermaid
classDiagram
    class ImperialWeighingMachine <<interface>>
    {
        +getWeightInPounds(): double
    }
    class ImperialWeighingMachineImpl
    {
    }
    class MetricWeighingMachine
    {
    }
    class WeighingMachineAdapter <<interface>>
    {
    }
    class WeightMachineAdapterImpl
    {
        +imperialWeighingMachine: ImperialWeighingMachine
    }
    ImperialWeighingMachine <|.. ImperialWeighingMachineImpl : implements
    WeighingMachineAdapter <|.. WeightMachineAdapterImpl : implements
    WeightMachineAdapterImpl o-- ImperialWeighingMachine : has-a
```


## structuralpatterns\.bridge\.solution

```mermaid
classDiagram
    class BreathingProcess <<interface>>
    {
        +breathe(): void
    }
    class Client
    {
    }
    class Dog
    {
    }
    class Fish
    {
    }
    class GillBreathing
    {
    }
    class LivingThings
    {
        +breathingProcess: BreathingProcess
        +breathe(): public void
    }
    class LungBreathing
    {
    }
    class Photosynthesis
    {
    }
    class Tree
    {
    }
    LivingThings <|-- Dog : is-a
    LivingThings <|-- Fish : is-a
    BreathingProcess <|.. GillBreathing : implements
    LivingThings o-- BreathingProcess : has-a
    BreathingProcess <|.. LungBreathing : implements
    BreathingProcess <|.. Photosynthesis : implements
    LivingThings <|-- Tree : is-a
```


## structuralpatterns\.composite\.filestructure\.solution

```mermaid
classDiagram
    class Directory
    {
        +directoryName: String
        +children: List<FileSystemComponent>
    }
    class File
    {
        +fileName: String
    }
    class FileSystemComponent <<interface>>
    {
        +printContents(): void
    }
    class FileSystemDemo
    {
    }
    FileSystemComponent <|.. Directory : implements
    FileSystemComponent <|.. File : implements
```


## structuralpatterns\.composite\.mathexpression

```mermaid
classDiagram
    class ArithmeticExpression <<interface>>
    {
        +evaluate(): int
    }
    class Expression
    {
        +leftExpression: ArithmeticExpression
        +rightExpression: ArithmeticExpression
        +operation: OperationType
    }
    class MathExpressionEvaluator
    {
    }
    class Number
    {
        +value: int
    }
    class OperationType <<enum>>
    {
    }
    ArithmeticExpression <|.. Expression : implements
    Expression o-- ArithmeticExpression : has-a
    Expression o-- OperationType : has-a
    ArithmeticExpression <|.. Number : implements
```


## structuralpatterns\.decorator

```mermaid
classDiagram
    class BasePizza <<interface>>
    {
        +getDescription(): String
        +getCost(): double
    }
    class ChickenDominator
    {
    }
    class Farmhouse
    {
    }
    class PlainPizza
    {
    }
    class TandooriPaneerDelight
    {
    }
    class PizzaShop
    {
    }
    class ToppingDecorator
    {
        +pizza: BasePizza
    }
    class ExtraCheeseTopping
    {
    }
    class MushroomTopping
    {
    }
    class PepperoniTopping
    {
    }
    class VeggiesTopping
    {
    }
    BasePizza <|.. ChickenDominator : implements
    BasePizza <|.. Farmhouse : implements
    BasePizza <|.. PlainPizza : implements
    BasePizza <|.. TandooriPaneerDelight : implements
    BasePizza <|.. ToppingDecorator : implements
    ToppingDecorator o-- BasePizza : has-a
    ToppingDecorator <|-- ExtraCheeseTopping : is-a
    ToppingDecorator <|-- MushroomTopping : is-a
    ToppingDecorator <|-- PepperoniTopping : is-a
    ToppingDecorator <|-- VeggiesTopping : is-a
```


## structuralpatterns\.facade

```mermaid
classDiagram
    class ECommerceApp
    {
    }
    class InventoryService
    {
    }
    class NotificationService
    {
    }
    class OrderFacade
    {
        +inventory: InventoryService
        +payment: PaymentService
        +shipping: ShippingService
        +notification: NotificationService
    }
    class PaymentService
    {
    }
    class ShippingService
    {
    }
    OrderFacade o-- InventoryService : has-a
    OrderFacade o-- PaymentService : has-a
    OrderFacade o-- ShippingService : has-a
    OrderFacade o-- NotificationService : has-a
```


## structuralpatterns\.flyweight\.roboticgame\.solution

```mermaid
classDiagram
    class HumanoidRobot
    {
    }
    class IRobot <<interface>>
    {
        +display(int x, int y): void
    }
    class RoboticDog
    {
    }
    class RoboticFactory
    {
    }
    class RoboticGameSimulation
    {
    }
    class Sprites
    {
    }
    IRobot <|.. HumanoidRobot : implements
    IRobot <|.. RoboticDog : implements
```


## structuralpatterns\.flyweight\.wordprocessor\.solution

```mermaid
classDiagram
    class DocumentCharacter
    {
        +character: char
        +fontType: String
        +size: int
    }
    class ILetter <<interface>>
    {
        +display(int row, int column): void
    }
    class LetterFactory
    {
    }
    class WordProcessorSimulation
    {
    }
    ILetter <|.. DocumentCharacter : implements
```


## structuralpatterns\.proxy

```mermaid
classDiagram
    class EmployeeDao <<interface>>
    {
        +getEmployeeInfo(int empID): void
        +createEmployee(EmployeeDo obj): void
    }
    class EmployeeDaoImpl
    {
    }
    class EmployeeDaoProxy
    {
        +empDaoObj: EmployeeDao
        +clientRole: String
    }
    class EmployeeDo
    {
    }
    class EmployeeManagement
    {
    }
    EmployeeDao <|.. EmployeeDaoImpl : implements
    EmployeeDao <|.. EmployeeDaoProxy : implements
    EmployeeDaoProxy o-- EmployeeDao : has-a
```


## video1solid\.dependencyinversion\.solution

```mermaid
classDiagram
    class DemoSolution
    {
    }
    class MacBook
    {
        +keyboard: Keyboard
        +mouse: Mouse
    }
```


## video1solid\.interfacesegregation\.solution

```mermaid
classDiagram
    class Chef
    {
    }
    class ChefTasks <<interface>>
    {
        +prepareFood(): void
        +decideMenu(): void
    }
    class MaintenanceTasks <<interface>>
    {
        +cleanTheKitchen(): void
        +reStockGroceries(): void
    }
    class SolutionDemo
    {
    }
    class Waiter
    {
    }
    class WaiterTasks <<interface>>
    {
        +serveFoodAndDrinks(): void
        +takeOrder(): void
    }
    ChefTasks <|.. Chef : implements
    WaiterTasks <|.. Waiter : implements
```


## video1solid\.liskovsubstitution\.example2\.solution

```mermaid
classDiagram
    class Bicycle
    {
    }
    class Car
    {
    }
    class EngineVehicle
    {
    }
    class MotorCycle
    {
    }
    class SolutionDemo
    {
    }
    class Vehicle
    {
    }
    Vehicle <|-- Bicycle : is-a
    EngineVehicle <|-- Car : is-a
    Vehicle <|-- EngineVehicle : is-a
    EngineVehicle <|-- MotorCycle : is-a
```


## video1solid\.openclosed\.solution

```mermaid
classDiagram
    class DatabaseInvoiceDao
    {
        +invoice: Invoice
    }
    class FileInvoiceDao
    {
        +invoice: Invoice
    }
    class InvoiceDao <<interface>>
    {
        +save(): void
    }
    class SolutionDemo
    {
    }
    InvoiceDao <|.. DatabaseInvoiceDao : implements
    InvoiceDao <|.. FileInvoiceDao : implements
```


## video1solid\.singleresponsibility\.solution

```mermaid
classDiagram
    class Invoice
    {
        +marker: Marker
        +quantity: int
        +total: int
    }
    class InvoiceDao
    {
        +invoice: Invoice
    }
    class InvoicePrinter
    {
        +invoice: Invoice
    }
    class Marker
    {
        +name: String
        +color: String
        +price: int
        +year: int
    }
    class SolutionDemo
    {
    }
    Invoice o-- Marker : has-a
    InvoiceDao o-- Invoice : has-a
    InvoicePrinter o-- Invoice : has-a
```


