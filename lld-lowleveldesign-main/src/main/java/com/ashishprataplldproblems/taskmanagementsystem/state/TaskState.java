package com.ashishprataplldproblems.taskmanagementsystem.state;

import com.ashishprataplldproblems.taskmanagementsystem.models.Task;
import com.ashishprataplldproblems.taskmanagementsystem.enums.TaskStatus;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reopenTask(Task task);
    TaskStatus getStatus();
}
