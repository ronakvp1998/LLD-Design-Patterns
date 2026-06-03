package com.ashishprataplldproblems.easy.taskmanagementsystem.strategy;

import com.ashishprataplldproblems.easy.taskmanagementsystem.models.Task;

import java.util.Comparator;
import java.util.List;

public class SortByDueDate implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }
}