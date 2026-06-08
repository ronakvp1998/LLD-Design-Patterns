package com.ashishprataplldproblems.easy.connectionpool;

import java.util.UUID;

public class DatabaseConnection implements Connection {
    private final String id;

    public DatabaseConnection() {
        // Simulating the expensive operation of creating a DB connection
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.id = UUID.randomUUID().toString();
        System.out.println("--- New Database Connection Created: " + this.id + " ---");
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Connection [" + id + "] executing query: " + query);
    }

    @Override
    public String getId() {
        return id;
    }
}