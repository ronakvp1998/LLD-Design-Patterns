package com.ashishprataplldproblems.easy.taskmanagementsystem.observer;

import com.ashishprataplldproblems.easy.taskmanagementsystem.models.Task;

public interface TaskObserver {
    void update(Task task, String changeType);
}
