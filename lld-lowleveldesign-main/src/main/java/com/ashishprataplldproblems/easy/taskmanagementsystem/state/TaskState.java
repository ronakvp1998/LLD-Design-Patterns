package com.ashishprataplldproblems.easy.taskmanagementsystem.state;

import com.ashishprataplldproblems.easy.taskmanagementsystem.models.Task;
import com.ashishprataplldproblems.easy.taskmanagementsystem.enums.TaskStatus;

public interface TaskState {
    void startProgress(Task task);
    void completeTask(Task task);
    void reopenTask(Task task);
    TaskStatus getStatus();
}
