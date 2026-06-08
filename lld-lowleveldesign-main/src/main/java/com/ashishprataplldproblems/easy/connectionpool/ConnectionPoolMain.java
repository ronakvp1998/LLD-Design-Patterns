package com.ashishprataplldproblems.easy.connectionpool;

public class ConnectionPoolMain {
        public static void main(String[] args) {
            System.out.println("Initializing Connection Pool (Initial: 2, Max: 4)...");
            ConnectionPool pool = ConnectionPool.getInstance(2, 4);

            // Create 8 threads (clients) trying to do DB work simultaneously
            // Since Max is 4, some threads will be forced to wait.
            for (int i = 1; i <= 8; i++) {
                Thread clientThread = new Thread(() -> {
                    Connection connection = null;
                    try {
                        System.out.println(Thread.currentThread().getName() + " is requesting a connection.");

                        connection = pool.getConnection();
                        System.out.println(Thread.currentThread().getName() + " acquired connection [" + connection.getId() + "]");

                        // Simulate doing DB work
                        connection.executeQuery("SELECT * FROM users");
                        Thread.sleep(2000); // Hold the connection for 2 seconds

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        if (connection != null) {
                            System.out.println(Thread.currentThread().getName() + " is releasing the connection.");
                            pool.releaseConnection(connection);
                        }
                    }
                }, "Client-Thread-" + i);

                clientThread.start();
            }
        }
    }