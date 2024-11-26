package com.LLD.Example.DesignBookMyShow;
import com.LLD.Example.DesignBookMyShow.Enums.City;

import java.util.*;
public class MovieController {

    Map<City,List<Movie>> cityVsMovie;
    List<Movie> allMovies;

    MovieController(){
        cityVsMovie = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    // Add movie to a particular city, make use of city VS Movies map
    void addMovie(Movie movie, City city){
        allMovies.add(movie);

        List<Movie> movies = cityVsMovie.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovie.put(city,movies);
    }

    Movie getMovieByName(String movieName){
        for(Movie movie : allMovies){
            if((movie.getMovieName()).equals(movieName)){
                return movie;
            }
        }
        return null;
    }


}
