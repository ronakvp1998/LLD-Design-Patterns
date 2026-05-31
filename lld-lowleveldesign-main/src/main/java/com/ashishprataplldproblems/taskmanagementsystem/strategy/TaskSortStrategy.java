package com.ashishprataplldproblems.taskmanagementsystem.strategy;

import com.ashishprataplldproblems.taskmanagementsystem.models.Task;

import java.util.List;

public interface TaskSortStrategy {
    void sort(List<Task> tasks);
}
