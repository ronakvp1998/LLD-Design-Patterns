package com.lldproblems.taskmanagementsystem.strategy;

import com.lldproblems.taskmanagementsystem.models.Task;

import java.util.List;

public interface TaskSortStrategy {
    void sort(List<Task> tasks);
}
