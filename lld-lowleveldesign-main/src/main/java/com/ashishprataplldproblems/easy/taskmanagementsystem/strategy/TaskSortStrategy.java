package com.ashishprataplldproblems.easy.taskmanagementsystem.strategy;

import com.ashishprataplldproblems.easy.taskmanagementsystem.models.Task;

import java.util.List;

public interface TaskSortStrategy {
    void sort(List<Task> tasks);
}
