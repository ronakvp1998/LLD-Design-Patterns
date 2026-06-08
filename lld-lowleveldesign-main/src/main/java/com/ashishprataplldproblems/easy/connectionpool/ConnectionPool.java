package com.ashishprataplldproblems.easy.connectionpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {

    // Singleton Instance
    private static volatile ConnectionPool instance;

    // Configuration
    private final int MAX_POOL_SIZE;
    private final BlockingQueue<Connection> availableConnections;
    private final AtomicInteger currentTotalConnections;

    // Private constructor for Singleton
    private ConnectionPool(int initialPoolSize, int maxPoolSize) {
        this.MAX_POOL_SIZE = maxPoolSize;
        this.availableConnections = new LinkedBlockingQueue<>(maxPoolSize);
        this.currentTotalConnections = new AtomicInteger(0);

        // Initialize the pool with a minimum number of connections
        for (int i = 0; i < initialPoolSize; i++) {
            availableConnections.offer(createNewConnection());
        }
    }

    // Double-checked locking for Singleton instantiation
    public static ConnectionPool getInstance(int initialPoolSize, int maxPoolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(initialPoolSize, maxPoolSize);
                }
            }
        }
        return instance;
    }

    // Acquire a connection from the pool
    public Connection getConnection() {
        Connection connection = availableConnections.poll(); // Non-blocking check

        if (connection != null) {
            return connection;
        }

        // If no connection is available, check if we can create a new one
        if (currentTotalConnections.get() < MAX_POOL_SIZE) {
            // Optimistically increment to reserve our spot
            if (currentTotalConnections.incrementAndGet() <= MAX_POOL_SIZE) {
                return createNewConnectionWithoutIncrement();
            } else {
                // We exceeded the max size concurrently, rollback the increment
                currentTotalConnections.decrementAndGet();
            }
        }

        // If max connections reached, block and wait for one to be returned
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for a connection...");
            return availableConnections.take(); // Blocking call
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted while waiting for connection", e);
        }
    }

    // Release the connection back to the pool
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            availableConnections.offer(connection);
            System.out.println("Connection [" + connection.getId() + "] returned to pool.");
        }
    }

    // Helper method to safely create a connection and increment counter
    private Connection createNewConnection() {
        currentTotalConnections.incrementAndGet();
        return new DatabaseConnection();
    }

    // Helper method to create connection when counter is already incremented
    private Connection createNewConnectionWithoutIncrement() {
        return new DatabaseConnection();
    }

    // For monitoring/testing purposes
    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }
}