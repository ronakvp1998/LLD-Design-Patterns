package com.ashishprataplldproblems.stackoverflow.strategy;

import com.ashishprataplldproblems.stackoverflow.entities.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
