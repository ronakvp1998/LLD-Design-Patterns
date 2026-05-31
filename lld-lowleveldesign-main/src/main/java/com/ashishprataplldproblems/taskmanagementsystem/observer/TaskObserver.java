package com.ashishprataplldproblems.taskmanagementsystem.observer;

import com.ashishprataplldproblems.taskmanagementsystem.models.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}
