package com.ashishprataplldproblems.hard.stackoverflow.strategy;

import com.ashishprataplldproblems.hard.stackoverflow.entities.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
