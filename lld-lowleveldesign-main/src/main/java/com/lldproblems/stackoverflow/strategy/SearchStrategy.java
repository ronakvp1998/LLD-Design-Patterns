package com.lldproblems.stackoverflow.strategy;

import com.lldproblems.stackoverflow.entities.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
