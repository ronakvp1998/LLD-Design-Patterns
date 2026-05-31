package com.ashishprataplldproblems.stackoverflow.strategy;

import com.ashishprataplldproblems.stackoverflow.entities.Question;
import com.ashishprataplldproblems.stackoverflow.entities.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class TagSearchStrategy implements SearchStrategy {
    private final Tag tag;

    public TagSearchStrategy(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getTags().stream()
                        .anyMatch(t -> t.getName().equalsIgnoreCase(tag.getName())))
                .collect(Collectors.toList());
    }
}
