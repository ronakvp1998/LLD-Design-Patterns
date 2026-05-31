package com.lldproblems.taskmanagementsystem.observer;

import com.lldproblems.taskmanagementsystem.models.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}
