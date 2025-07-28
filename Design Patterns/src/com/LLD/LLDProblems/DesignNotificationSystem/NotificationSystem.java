//package com.LLD.LLDProblems.DesignNotificationSystem;// Java version of the C++ Notification System using Decorator, Observer, Strategy, and Singleton Patterns
//import java.util.*;
//
///*============================
//      Notification & Decorators
//=============================*/
//
//interface INotification {
//    String getContent();
//}
//
//// Concrete Notification: simple text notification.
//class SimpleNotification implements com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification {
//    private String text;
//
//    public SimpleNotification(String msg) {
//        this.text = msg;
//    }
//
//    public String getContent() {
//        return text;
//    }
//}
//
//// Abstract Decorator: wraps a Notification object.
//abstract class INotificationDecorator implements com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification {
//    protected com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification notification;
//
//    public INotificationDecorator(com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification n) {
//        this.notification = n;
//    }
//}
//
//// Decorator to add a timestamp to the content.
//class TimestampDecorator extends com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationDecorator {
//    public TimestampDecorator(com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification n) {
//        super(n);
//    }
//
//    public String getContent() {
//        return "[2025-04-13 14:22:00] " + notification.getContent();
//    }
//}
//
//// Decorator to append a signature to the content.
//class SignatureDecorator extends com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationDecorator {
//    private String signature;
//
//    public SignatureDecorator(com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification n, String sig) {
//        super(n);
//        this.signature = sig;
//    }
//
//    public String getContent() {
//        return notification.getContent() + "\n-- " + signature + "\n\n";
//    }
//}
//
///*============================
//  Observer Pattern Components
//=============================*/
//
//interface IObserver {
//    void update();
//}
//
//interface IObservable {
//    void addObserver(com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver observer);
//    void removeObserver(com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver observer);
//    void notifyObservers();
//}
//
//// Concrete Observable
//class NotificationObservable implements com.LLD.LLDProblems.DesignNotificationSystem.updated.IObservable {
//    private List<com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver> observers = new ArrayList<>();
//    private com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification currentNotification;
//
//    public void addObserver(com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver obs) {
//        observers.add(obs);
//    }
//
//    public void removeObserver(com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver obs) {
//        observers.remove(obs);
//    }
//
//    public void notifyObservers() {
//        for (com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver observer : observers) {
//            observer.update();
//        }
//    }
//
//    public void setNotification(com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification notification) {
//        this.currentNotification = notification;
//        notifyObservers();
//    }
//
//    public com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification getNotification() {
//        return currentNotification;
//    }
//
//    public String getNotificationContent() {
//        return currentNotification.getContent();
//    }
//}
//
//// Concrete Observer 1
//class Logger implements com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver {
//    private com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable notificationObservable;
//
//    public Logger(com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable observable) {
//        this.notificationObservable = observable;
//    }
//
//    public void update() {
//        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
//    }
//}
//
///*============================
//  Strategy Pattern Components (Concrete Observer 2)
//=============================*/
//
//interface INotificationStrategy {
//    void sendNotification(String content);
//}
//
//class EmailStrategy implements com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationStrategy {
//    private String emailId;
//
//    public EmailStrategy(String emailId) {
//        this.emailId = emailId;
//    }
//
//    public void sendNotification(String content) {
//        System.out.println("Sending email Notification to: " + emailId + "\n" + content);
//    }
//}
//
//class SMSStrategy implements com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationStrategy {
//    private String mobileNumber;
//
//    public SMSStrategy(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public void sendNotification(String content) {
//        System.out.println("Sending SMS Notification to: " + mobileNumber + "\n" + content);
//    }
//}
//
//class PopUpStrategy implements com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationStrategy {
//    public void sendNotification(String content) {
//        System.out.println("Sending Popup Notification: \n" + content);
//    }
//}
//
//class NotificationEngine implements com.LLD.LLDProblems.DesignNotificationSystem.updated.IObserver {
//    private com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable notificationObservable;
//    private List<com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationStrategy> notificationStrategies = new ArrayList<>();
//
//    public NotificationEngine(com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable observable) {
//        this.notificationObservable = observable;
//    }
//
//    public void addNotificationStrategy(com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationStrategy ns) {
//        this.notificationStrategies.add(ns);
//    }
//
//    public void update() {
//        String notificationContent = notificationObservable.getNotificationContent();
//        for (com.LLD.LLDProblems.DesignNotificationSystem.updated.INotificationStrategy strategy : notificationStrategies) {
//            strategy.sendNotification(notificationContent);
//        }
//    }
//}
//
///*============================
//       NotificationService
//=============================*/
//
//// The NotificationService manages notifications. It keeps track of notifications.
//// Any client code will interact with this service.
//
//// Singleton class
//class NotificationService {
//    private com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable observable;
//    private static com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationService instance;
//    private List<com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification> notifications = new ArrayList<>();
//
//    private NotificationService() {
//        observable = new com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable();
//    }
//
//    public static com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationService getInstance() {
//        if (instance == null) {
//            instance = new com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationService();
//        }
//        return instance;
//    }
//
//    public com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable getObservable() {
//        return observable;
//    }
//
//    public void sendNotification(com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification notification) {
//        notifications.add(notification);
//        observable.setNotification(notification);
//    }
//}
//
//public class NotificationSystem {
//    public static void main(String[] args) {
//
//        // Create NotificationService.
//        com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationService notificationService = com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationService.getInstance();
//
//        // Get Observable
//        com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationObservable notificationObservable = notificationService.getObservable();
//
//        // Create Logger Observer
//        com.LLD.LLDProblems.DesignNotificationSystem.updated.Logger logger = new com.LLD.LLDProblems.DesignNotificationSystem.updated.Logger(notificationObservable);
//
//        // Create NotificationEngine observers.
//        com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationEngine notificationEngine = new com.LLD.LLDProblems.DesignNotificationSystem.updated.NotificationEngine(notificationObservable);
//
//        notificationEngine.addNotificationStrategy(new com.LLD.LLDProblems.DesignNotificationSystem.updated.EmailStrategy("random.person@gmail.com"));
//        notificationEngine.addNotificationStrategy(new com.LLD.LLDProblems.DesignNotificationSystem.updated.SMSStrategy("+91 9876543210"));
//        notificationEngine.addNotificationStrategy(new com.LLD.LLDProblems.DesignNotificationSystem.updated.PopUpStrategy());
//
//        // Attach these observers.
//        notificationObservable.addObserver(logger);
//        notificationObservable.addObserver(notificationEngine);
//
//        // Create a notification with decorators.
//        com.LLD.LLDProblems.DesignNotificationSystem.updated.INotification notification = new com.LLD.LLDProblems.DesignNotificationSystem.updated.SimpleNotification("Your order has been shipped!");
//        notification = new com.LLD.LLDProblems.DesignNotificationSystem.updated.TimestampDecorator(notification);
//        notification = new com.LLD.LLDProblems.DesignNotificationSystem.updated.SignatureDecorator(notification, "Customer Care");
//
//        notificationService.sendNotification(notification);
//    }
//}
