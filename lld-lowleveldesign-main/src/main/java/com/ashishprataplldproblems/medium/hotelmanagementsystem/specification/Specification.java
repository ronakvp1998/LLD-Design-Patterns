package com.ashishprataplldproblems.medium.hotelmanagementsystem.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T item);
    Specification<T> and(Specification<T> other);
}
