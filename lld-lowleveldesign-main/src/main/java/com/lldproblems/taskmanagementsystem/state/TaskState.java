package com.lldproblems.taskmanagementsystem.state;

import com.lldproblems.taskmanagementsystem.models.Task;
import com.lldproblems.taskmanagementsystem.enums.TaskStatus;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reopenTask(Task task);
    TaskStatus getStatus();
}
