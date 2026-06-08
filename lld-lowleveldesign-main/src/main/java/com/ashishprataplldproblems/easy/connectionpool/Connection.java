package com.ashishprataplldproblems.easy.connectionpool;

public interface Connection {
    void executeQuery(String query);
    String getId();
}