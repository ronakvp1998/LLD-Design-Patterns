package com.lldproblems.movieticketbookingsystem.observer;

import com.lldproblems.movieticketbookingsystem.entities.Movie;

public interface MovieObserver {
    void update(Movie movie);
}
